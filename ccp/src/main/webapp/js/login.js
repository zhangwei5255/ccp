ccp.model.data.LoginModel = function(dataModel) {
	var self = this;
	self.userId = ko.observable(dataModel.userId);
	self.pwd = ko.observable(dataModel.pwd);
	self.isSave = ko.observable(true);		//JSのみ使う
	self.vervifyCode = ko.observable()		//JSのみ使う
	self.captchaCss = ko.observable("fa fa-pencil-square-o");		//JSのみ使う
	//self.messages =  ko.observableArray(dataModel.messages);
	self.baseDomain = ko.observable(new ccp.model.data.BaseDomain(dataModel));
}

ccp.vm.LoginViewModel = function() {
	var self = this;
	var empty = {
			userId : "",
			pwd : "",
			baseDomain : null
	};

	self.dataModel = new ccp.model.data.LoginModel(empty);
	self.handler = new ccp.vm.ErrorViewModel();
	self.messages = ko.observableArray();
	self.ctlVervifyCode = new GVerify("v_container");

	self.processing = {
		onBlurUserId : false,
		onBlurPwd : false,
		onValidate : false,
		doNext : false
	};

	self.bind = function() {
		ko.applyBindings(self); // This makes Knockout get to work
	};

	self.onBlurUserId = function(){
		if (self.processing.onBlurUserId) {
			return;
		}

		var map = myCookie.item(myCookie.keys.login);
		self.dataModel.pwd(map[self.dataModel.userId()]);

		self.processing.onBlurUserId = false;
	};

	self.onBlurPwd = function(){
		if (self.processing.onBlurPwd) {
			return;
		}


		self.processing.onBlurPwd = false;
	};


	self.onValidate = function(){
		if (self.processing.onValidate) {
			return;
		}
		if(self.dataModel.vervifyCode()){
			var res = self.ctlVervifyCode.validate(self.dataModel.vervifyCode());
			if(res){
				//alert("验证正确");
				self.dataModel.captchaCss("fa fa-check-circle fa-6 ok");
			}else{
				//alert("验证码错误");
				self.dataModel.captchaCss("fa fa-window-close fa-6 ng");
			}
		}

		self.processing.onValidate = false;
	};


	self.doNext = function() {
		if (self.processing.doNext) {
			return;
		}
		self.processing.doNext = true;
		var u = ROOT_NAME + '/login/next';
		$.ajax({
			type : 'POST',
			url : u,
			data : toJSON(self.dataModel),
			contentType: 'application/json',
			datatype: 'json',
			scriptCharset: 'utf-8'
		}).done(function(response) {
			// cookieオブジェクトの取得
			var cookieObj = myCookie.item(myCookie.keys.login);
			if(self.dataModel.isSave() == true){
				cookieObj[self.dataModel.userId()] = self.dataModel.pwd();
				// cookieオブジェクトの設定
				myCookie.item(myCookie.keys.login, cookieObj);
			}else{
		/*		// cookieオブジェクトからパスワードを削除
				cookieObj[self.dataModel.userId()] = null;*/
				$.each(cookieObj , function(k, v) {
					 // localStorageのkeyはkeysのvalueです。
			 		 if(k === self.dataModel.userId()){
			 			delete cookieObj[k];
			 		 }
				});

				myCookie.item(myCookie.keys.login, cookieObj);
			}

			Utils.changeViewing("admin/welcome.html");

		}).fail(function(xhr, exception) {
			self.handler.handle(xhr, exception);
			self.dataModel.baseDomain().messages(self.handler.errors);
		}).always(function() {
			self.processing.doNext = false;
		});
	};



};