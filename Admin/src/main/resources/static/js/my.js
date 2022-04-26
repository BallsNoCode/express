//new function() {
//	var _self = this;
//	_self.width = 640; //设置默认最大宽度
//	_self.fontSize = 100; //默认字体大小
//	_self.widthProportion = function() {
//		var p = (document.body &&
//			document.body.clientWidth ||
//			document.getElementsByTagName("html")[0].offsetWidth) / _self.width;
//		return p > 1 ? 1 : p < 0.5 ? 0.5 : p;
//	};
//	_self.changePage = function() {
//		document.getElementsByTagName("html")[0].setAttribute("style", "font-size:" + _self.widthProportion() * _self.fontSize + "px !important");
//	}
//	_self.changePage();
//	window.addEventListener("resize", function() {
//		_self.changePage();
//	}, false);
//};

(function () {
    // 手机页面rem适应
    var currClientWidth,
        fontValue,
        originWidth;
    originWidth = 750; //ui设计稿的宽度，一般750或640
    __resize();
    window.addEventListener('resize', __resize, false);

    function __resize() {
        currClientWidth = document.documentElement.clientWidth;
        if (currClientWidth > 768) {
            currClientWidth = 768;
        }
        if (currClientWidth < 320) {
            currClientWidth = 320;
        }
        fontValue = ((625 * currClientWidth) / originWidth).toFixed(2);
        document.documentElement.style.fontSize = fontValue + '%';
    }


})();

/**
* 文本框根据输入内容自适应高度
* @param                {HTMLElement}           输入框元素
* @param                {Number}                设置光标与输入框保持的距离(默认0)
* @param                {Number}                设置最大高度(可选)
*/
var autoTextarea = function (elem, extra, maxHeight) {
    extra = extra || 0;
    var isFirefox = !!document.getBoxObjectFor || 'mozInnerScreenX' in window,
            isOpera = !!window.opera && !!window.opera.toString().indexOf('Opera'),
            addEvent = function (type, callback) {
                    elem.addEventListener ?
                            elem.addEventListener(type, callback, false) :
                            elem.attachEvent('on' + type, callback);
            },
            getStyle = elem.currentStyle ? function (name) {
                    var val = elem.currentStyle[name];

                    if (name === 'height' && val.search(/px/i) !== 1) {
                            var rect = elem.getBoundingClientRect();
                            return rect.bottom - rect.top -
                                    parseFloat(getStyle('paddingTop')) -
                                    parseFloat(getStyle('paddingBottom')) + 'px';
                    };

                    return val;
            } : function (name) {
                    return getComputedStyle(elem, null)[name];
            },
            minHeight = parseFloat(getStyle('height'));

    elem.style.resize = 'none';
    var change = function () {
            var scrollTop, height,
                    padding = 0,
                    style = elem.style;

            if (elem._length === elem.value.length) return;
            elem._length = elem.value.length;

            if (!isFirefox && !isOpera) {
                    padding = parseInt(getStyle('paddingTop')) + parseInt(getStyle('paddingBottom'));
            };
            scrollTop = document.body.scrollTop || document.documentElement.scrollTop;

            elem.style.height = minHeight + 'px';
            if (elem.scrollHeight > minHeight) {
                    if (maxHeight && elem.scrollHeight > maxHeight) {
                            height = maxHeight - padding;
                            style.overflowY = 'auto';
                    } else {
                            height = elem.scrollHeight - padding;
                            style.overflowY = 'hidden';
                    };
                    style.height = height + extra + 'px';
                    scrollTop += parseInt(style.height) - elem.currHeight;
                    document.body.scrollTop = scrollTop;
                    document.documentElement.scrollTop = scrollTop;
                    elem.currHeight = parseInt(style.height);
            };
    };

    addEvent('propertychange', change);
    addEvent('input', change);
    addEvent('focus', change);
    change();
};




