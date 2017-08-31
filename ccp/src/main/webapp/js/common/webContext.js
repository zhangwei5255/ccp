ccp.enums.web.myCookie = function(){
	var self = this;
	self.keys =  {
			login : 'ccp.enums.web.myCookie.keys.login'
	}

	self.item = function(key, val){
		if(!val){												//getter
			$.each(self.keys , function(k, v) {
				 // localStorageのkeyはkeysのvalueです。
		 		 if(key === v){
		 			return localStorage.getItem(key);
		 		 }
			});

			return "";
		}else{													//setter
			$.each(self.keys , function(k, v) {
				 // localStorageのkeyはkeysのvalueです。
		 		 if(key === v){
		 			localStorage.setItem(key, val);
		 		 }
			});
		}

	}


	self.remove = function(key){
		// KEYの存在チェック
/*		if(key in self.keys == true){
			localStorage.removeItem(key);
		}*/

		$.each(self.keys , function(k, v) {
			 // localStorageのkeyはkeysのvalueです。
	 		 if(key === v){
	 			localStorage.removeItem(key);
	 		 }
		});
	}
	self.clear = function() {
		//localStorage.clear();    // 全て削除される「ccp.enums.web.myCookie.keys以外を含む」
		/*for (var key in self.keys) {
			// localStorageのkeyはkeysのvalueです。
			localStorage.removeItem(key);		//NG
		}*/

		$.each(self.keys , function(k, v) {
			 // localStorageのkeyはkeysのvalueです。
	 		localStorage.removeItem(v);
		});

    }

}

ccp.enums.web.myRequest = function(){
	var self = this;
	self.keys =  {
			login : 'ccp.enums.web.myRequest.keys.login',
			login2: 'ccp.enums.web.myRequest.keys.login2'
	}

	self.item = function(key, val){
		if(!val){												//getter
			$.each(self.keys , function(k, v) {
				 // localStorageのkeyはkeysのvalueです。
		 		 if(key === v){
		 			return sessionStorage.getItem(key);
		 		 }
			});

			return "";
		}else{													//setter
			$.each(self.keys , function(k, v) {
				 // localStorageのkeyはkeysのvalueです。
		 		 if(key === v){
		 			sessionStorage.setItem(key, val);
		 		 }
			});
		}

	}

	self.remove = function(key){
		$.each(self.keys , function(k, v) {
			 // localStorageのkeyはkeysのvalueです。
	 		 if(key === v){
	 			sessionStorage.removeItem(key);
	 		 }
		});
	}
	self.clear = function() {
		$.each(self.keys , function(k, v) {
			 // localStorageのkeyはkeysのvalueです。
			sessionStorage.removeItem(v);
		});
    }

	self.save = function(key, val){
		self.clear();
		self.item(key, val);
	}

}

ccp.enums.web.mySession = function(){
	var self = this;
	self.keys =  {
			login : 'ccp.enums.web.mySession.keys.login'
	}

	self.item = function(key, val){
		if(!val){												//getter
			$.each(self.keys , function(k, v) {
				 // localStorageのkeyはkeysのvalueです。
		 		 if(key === v){
		 			return sessionStorage.getItem(key);
		 		 }
			});

			return "";
		}else{													//setter
			$.each(self.keys , function(k, v) {
				 // localStorageのkeyはkeysのvalueです。
		 		 if(key === v){
		 			sessionStorage.setItem(key, val);
		 		 }
			});
		}

	}

	self.remove = function(key){
		$.each(self.keys , function(k, v) {
			 // localStorageのkeyはkeysのvalueです。
	 		 if(key === v){
	 			sessionStorage.removeItem(key);
	 		 }
		});
	}

	self.clear = function() {
		$.each(self.keys , function(k, v) {
			 // localStorageのkeyはkeysのvalueです。
			sessionStorage.removeItem(v);
		});
    }

}

var myCookie = new ccp.enums.web.myCookie();
var myRequest = new ccp.enums.web.myRequest();
var mySession = new ccp.enums.web.mySession();