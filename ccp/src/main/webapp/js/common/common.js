//tomcatのcontextPath： デフォルト「/ccp」→「/」のため
/*var ROOT_NAME = '/ccp';*/
var ROOT_NAME = '';

if (typeof Utils === "undefined") {
	var Utils = {};
}

(function($) {
	$.extend({
		getParameter : function getParameter() {
			// / <summary>
			// / URLのパラメーターを取得
			// / </summary>

			var arg = new Object;
			var pair = location.search.substring(1).split('&');
			for (i = 0; pair[i]; i++) {
				var kv = pair[i].split('=');
				arg[kv[0]] = unescape(kv[1]);
			}
			return arg;
		}
	});
})(jQuery);


ccp.enums.color = function() {
	var values = {
	         BLACK: '#000000',
	         RED: '#FF0000',
	         GREEN: '#00FF00'
	    }

	    return values;
};

//使い方①：ccp.enums.color().BLACK
//使い方②
var color = new ccp.enums.color();

ccp.model.data.BaseDomain = function() {
	var self = this;
	self.messages = ko.observableArray();
}

ccp.model.data.BaseDomain = function(dataModel) {
	var self = this;
	self.messages = ko.observableArray();

	// dataModelがJSデータの場合
	if(dataModel.baseDomain){
		self.messages = ko.observable(dataModel.baseDomain.messages);
		return;
	}

	if(dataModel.messages){
		self.messages = ko.observable(dataModel.messages);
	}


}

// JSONにKOオブジェクトを変換
function toJSON(data) {
	var d = ko.toJS(data);
	return ko.toJSON(d);
}

// 複数の別HTMLを読み込む
function loadHtml(loadList, callbackFn) {

	var cnt = 0;
	$.each(loadList, function(i, row) {
		if (!row.url) {
			return;
		}
		$(row.id).load(row.url, null, loadCallBack);
	});

	function loadCallBack() {
		cnt = cnt + 1;
		if (cnt === loadList.length) {
			// callbackFnを呼び出す
			callbackFn();
		}
	}
}

Utils.changeViewing = function(page) {
	window.location.href = page;
}

ccp.model.data.Message = function(msg) {
	var self = this;
	self.code = msg.code;
	self.message = ko.observable(msg.message);
};

ccp.model.data.ValidationMessage = function(validation) {
	var self = this;
	self.path = validation.path;
	self.message = validation.message;
	self.fullMessage = ko.computed(function() {
		var key = self.path.substring(self.path.lastIndexOf(".") + 1);
		var p = $('label[for="' + key + '"]').text();
		return p + ":" + self.message;
	});
};

ccp.model.data.ErrorMessage = function(error) {
	var self = this;
	self.code = error.code;
	self.id = error.id;
	self.message = error.message;
	self.status = error.status;
};

ccp.model.data.ErrorConfig = function(config) {
	var self = this;
	self.conflictErrorPage = config.conflictErrorPage;
	self.conflictErrorMessage = config.conflictErrorMessage;
};

ccp.vm.ErrorViewModel = function() {
	var self = this;
	self.validations = ko.observableArray([]).extend({
		arrayExtensions : true
	});
	self.errors = ko.observableArray([]).extend({
		arrayExtensions : true
	});
	self.handle = function(xhr, exception) {
		/**
		 * ページ遷移中による処理中断 エラー処理は何もしない。
		 */
		if (xhr.statusText == 'canceled') {
			return;
		}

		if ($('.modal.fade.in')[0]) {
			$('.modal').scrollTop(0);
		} else {
			window.scrollTo(0, 0);
		}
		var statusCode = xhr.status;
		switch (statusCode) {
		case 400:
			try {
				self.validations.removeAll();
				self.errors = JSON.parse(xhr.responseText);
			} catch (e) {
				ccp.model.ErrorModel.goToPageNotFound();
			}
			break;
		case 401: // 権限なし
			ccp.model.ErrorModel.goToVerifyFound();
			break;
		case 404:
			ccp.model.ErrorModel.goToPageNotFound();
			break;
		case 408:
			ccp.model.ErrorModel.goToSessionTimeout();
			break;
		/*
		 * case 409: ccp.model.ErrorModel.goToConflictError(self.config); break;
		 */
		default:
			ccp.model.ErrorModel.goToSystemError();
		}
	};
	self.removeValidationMessage = function() {
		self.validations.removeAll();
		self.removeValidErrorHighlight();
	};
	self.removeMessage = function() {
		self.errors.removeAll();
	};
	self.addMessage = function(msg) {
		this.removeMessage();
		self.errors.push(new ccp.model.data.ErrorMessage({
			code : "",
			message : msg,
			id : "",
			status : -1
		}));
	};
	self.addError = function(response) {
		var error = JSON.parse(response.responseText);
		self.validations.push(new ccp.model.data.ErrorMessage(error));
	};
	self.setConfig = function(config) {
		self.config = new ccp.model.data.ErrorConfig(config);
	};
	/**
	 * バリデーションエラーの背景色設定を初期化
	 */
	self.removeValidErrorHighlight = function() {
		$('.valid_error_highlight').removeClass('valid_error_highlight');
	};
	/**
	 * バリデーションエラーの背景色設定
	 */
	self.showValidErrorHighlight = function() {

		self.removeValidErrorHighlight();

		// 【 行 】に対して背景色設定
		$('.help-block').not('.valid_error_with_prev_th .help-block').not(
				'.valid_error_fill_group .help-block').closest('tr').addClass(
				'valid_error_highlight');

		// 【個別ペア】に対して背景色設定
		$('.valid_error_with_prev_th').has('.help-block').addClass(
				'valid_error_highlight').prev('th').addClass(
				'valid_error_highlight');

		// 【グループ】に対して背景色設定
		$('.valid_error_fill_group').has('.help-block').addClass(
				'valid_error_highlight');

		// 【関連見出】に対して設定
		$('.valid_error_relation_group').has('.help-block').find(
				'.valid_error_relation_group_th').addClass(
				'valid_error_highlight');
	};
};

ccp.model.ErrorModel = {
	goToVerifyFound : function() {
		Utils.changeViewing(ROOT_NAME + "/err/unauthorized.html");
	},
	goToPageNotFound : function() {
		Utils.changeViewing(ROOT_NAME + "/err/notFound.html");
	},
	goToSystemError : function() {
		Utils.changeViewing(ROOT_NAME + "/err/sysErr.html");
	},
	goToSessionTimeout : function() {
		Utils.changeViewing(ROOT_NAME + "/err/sessonTimeout.html");
	}
};