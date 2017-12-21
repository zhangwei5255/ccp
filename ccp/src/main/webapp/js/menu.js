ccp.vm.MenuViewModel = function() {

	var self = this;

	self.doExcelVsProptites = function() {
		Utils.changeViewing("tools/excelVsProptites.html");
	};


	self.doProVsStg = function() {
		Utils.changeViewing("tools/proVsStg.html");
	};


	self.bind = function() {
		ko.applyBindings(self); // This makes Knockout get to work
	};

};