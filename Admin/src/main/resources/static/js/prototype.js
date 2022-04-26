(function(window,undefined){
	var Star = function(config){
		this.init(config);
	}
	
	Star.prototype = {
		constructor:Star,
		init:function(config){
			var _this=this;
			_this.callback = config.callback || function() {};
			// dom实例化
			_this.InnderHtml(config)
		},
		// dom实例化
		InnderHtml:function(config){
			var _this = this;
			
			// 默认数据
			var defaultData = config.wheels;
			
			// better_scroll滚动选择逻辑
			// ChineseDistricts——省市区数据源
			// brtter_scroll实例化var
			var cutt_off=0;
			var qs = "";
			var qs1 = ""
			var qs2 = "";
			var dataPicker1 = []; //省
			var numStr = [];
			var numStr1 = [];
			var numStr2 = [];
			var province="";//省title
			var city="";//市title
			var area="";//区title
			// 港澳台
			var GAT = [{
				code: "710000",
				address: "台湾"
			}, {
				code: "810000",
				address: "香港特别行政区"
			}, {
				code: "820000",
				address: "澳门特别行政区"
			}]
			
			// 弹起省市区选择
			$("#"+config.dataId).click(function(){
				ChineseDistricts[86]["A-G"].forEach((item) => {
					dataPicker1.push(item)
				})
				ChineseDistricts[86]["H-K"].forEach((item) => {
					dataPicker1.push(item)
				})
				ChineseDistricts[86]["L-S"].forEach((item) => {
					dataPicker1.push(item)
				})
				ChineseDistricts[86]["T-Z"].forEach((item) => {
					dataPicker1.push(item)
				})
				GAT.forEach((item) => {
					dataPicker1.push(item)
				})
				
				var dom = `<div class="Provincial_urban_areas hide">
							<div class="Provincial_urban_areas1 areasHide"></div>
							<div class="Provincial_urban_areas2">
								<div class="Provincial_urban_areas2_xuanze">
									<span class="areasHide">取消</span>
									<span class="areasOk">确定</span>
								</div>
								<div class="betterHome">
									<div class="betterHeader">
										<div id="betterWrapper" class="betterHeader1">
											<div class="betterContent wheel-scroll"></div>
										</div>
										<div class="li_position"></div>
									</div>
									<div class="betterHeader">
										<div id="betterWrapper1" class="betterHeader1">
											<div class="betterContent1 wheel-scroll"></div>
										</div>
										<div class="li_position"></div>
									</div>
									<div class="betterHeader">
										<div id="betterWrapper2" class="betterHeader1">
											<div class="betterContent2 wheel-scroll"></div>
										</div>
										<div class="li_position"></div>
									</div>
								</div>
							</div>
						</div>`;
				console.log(cutt_off)
				if(cutt_off==0){
					$("#"+config.id).after(dom);
					// 获取省一级
					dataPicker1.forEach((item) => {
						numStr.push(`<div class="wheel-item" data-code="${item.code}">${item.address}</div>`)
					})
					$(".betterContent").html(numStr)
					
					defaultData = $("#"+config.id).val()!=""?$("#"+config.id).val().split("-"):config.wheels;
					$("#"+config.dataId).find(".Provincial_urban_areas").removeClass("hide")
					setTimeout(function(){
						$("#"+config.dataId).find(".Provincial_urban_areas .Provincial_urban_areas2").addClass("Provincial_urban_areas2_tr")
						// 实例化brtter_scroll省
						brtter_scroll1();
						if(defaultData!=""){
							$("#betterWrapper").find(".wheel-scroll .wheel-item").eq(dataPicker1.findIndex(v => v.address === defaultData[0])).addClass("li_color");
							qs.wheelTo(dataPicker1.findIndex(v => v.address === defaultData[0]));
							// 省市区默认值自动滚到指定位置
							erRender(ChineseDistricts[dataPicker1[dataPicker1.findIndex(v => v.address === defaultData[0])].code]);
						}else{
							$("#betterWrapper").find(".wheel-scroll .wheel-item").eq(0).addClass("li_color");
							qs.wheelTo(0);
							// 省市区默认值自动滚到指定位置
							erRender(ChineseDistricts[dataPicker1[0].code]);
						}
						// 取消弹层
						$(".areasHide").click(function(){
							hideareas();
						})
						
						// 获取数据
						$("#"+config.dataId).find(".Provincial_urban_areas .Provincial_urban_areas2 .areasOk").click(function(){
							hideareas();
							if(defaultData!=""){
								console.log(area,"area")
								_this.callback(ReturnData({
									province:(province==""?defaultData[0]:province),
									city:(city==""?$("#betterWrapper1").find(".wheel-scroll .wheel-item").eq(0).html():city),
									area:(area==""?($("#betterWrapper2").find(".wheel-scroll .wheel-item").eq(0).html() || ""):area)
								}))
							}else{
								_this.callback(ReturnData({
									province:(province==""?$("#betterWrapper").find(".wheel-scroll .wheel-item").eq(0).html():province),
									city:(city==""?$("#betterWrapper1").find(".wheel-scroll .wheel-item").eq(0).html():city),
									area:(area==""?($("#betterWrapper2").find(".wheel-scroll .wheel-item").eq(0).html() || ""):area)
								}));
							}
						})
					},30)
				}
			})
			function hideareas(){
				$("#"+config.dataId).find(".Provincial_urban_areas .Provincial_urban_areas2") .removeClass("Provincial_urban_areas2_tr");
				setTimeout(function(){
					$("#"+config.dataId).find(".Provincial_urban_areas").addClass("hide")
					
					$("#"+config.dataId).find(".Provincial_urban_areas").remove();
					dataPicker1 = []; //省
					numStr=[];
					numStr1=[];
					numStr2=[];
					cutt_off=0;
					$(".betterContent").css({"transform": "translateY(0)"})
					$(".betterContent1").css({"transform": "translateY(0)"})
					$(".betterContent2").css({"transform": "translateY(0)"})
					$("#betterWrapper").find(".wheel-scroll .wheel-item").eq(0).addClass("li_color");
					$("#betterWrapper").find(".wheel-scroll .wheel-item").eq(0).siblings().removeClass("li_color");
				},320)
				
				// 处理冒泡
				window.event? window.event.cancelBubble = true : e.stopPropagation();
			}
			
			// 二级渲染
			function erRender(val) {
				numStr1 = [];
				for (let i in val) {
					numStr1.push(`<div class="wheel-item" data-code="${i}">${val[i]}</div>`)
				}
				$(".betterContent1").html(numStr1)
				// 实例化市
				brtter_scroll2();
				// 二级默认滚动到指定位置
				if(cutt_off==0 && defaultData!=""){
					qs1.wheelTo(dataArrty(val).findIndex(v => v.address === defaultData[1]));
					sanRender(ChineseDistricts[dataArrty(val)[dataArrty(val).findIndex(v => v.address === defaultData[1])].code])
				}else{
					sanRender(ChineseDistricts[dataArrty(val)[0].code])
				}
				// 数累加，免得第一次sanRender()执行两次
				cutt_off=1;
			}
			// 三级渲染
			function sanRender(val) {
				numStr2 = [];
				for (let i in val) {
					numStr2.push(`<div class="wheel-item" data-code="${i}">${val[i]}</div>`)
				}
				$(".betterContent2").html(numStr2)
				// 实例化区
				brtter_scroll3();
				// 二级默认滚动到指定位置
				if(cutt_off==0){
					qs2.wheelTo(dataArrty(val).findIndex(v => v.address === defaultData[2]));
				}
			}
			
			// 省
			function brtter_scroll1() {
				var wrapper = document.getElementById("betterWrapper")
				qs = BetterScroll.createBScroll(wrapper, {
					wheel: {
						selectedIndex: 0, //设置默认在哪个位置
						rotate: 5, //数据转动角度
						adjustTime: 400, //设置时间
						wheelWrapperClass: 'wheel-scroll',
						wheelItemClass: 'wheel-item',
					},
					observeDOM: false,
					mouseWheel: true,
					click:true,
					tap:true,
				})
				//滚动到索引对应的位置
				qs.wheelTo(0);
				qs.on('scrollEnd', () => {
					numStr1 = [];
					//滚动完成之后获取当前选取的索引值
					let index = qs.getSelectedIndex();
					let codeIndex = dataPicker1[qs.getSelectedIndex()].code;
					let name = ChineseDistricts[codeIndex];
					if(cutt_off!=0){
						province="";
						city="";
						area="";
						$(".betterContent1").css({"transform": "translateY(0)"})
						$(".betterContent2").css({"transform": "translateY(0)"})
						erRender(name);
						province=$("#betterWrapper").find(".wheel-scroll .wheel-item").eq(index).html();
					}
			
					// 为当前索引添加样式
					$("#betterWrapper").find(".wheel-scroll .wheel-item").eq(index).addClass("li_color");
					$("#betterWrapper").find(".wheel-scroll .wheel-item").eq(index).siblings().removeClass("li_color");
				})
			}
			
			// 市
			function brtter_scroll2() {
				var wrapper1 = document.getElementById("betterWrapper1")
				qs1 = BetterScroll.createBScroll(wrapper1, {
					wheel: {
						selectedIndex: 0, //设置默认在哪个位置
						rotate: 5, //数据转动角度
						adjustTime: 400, //设置时间
						wheelWrapperClass: 'wheel-scroll',
						wheelItemClass: 'wheel-item',
					},
					observeDOM: false,
					mouseWheel:true,
					click:true,
					tap:true,
				})
				qs1.wheelTo(0);
				$("#betterWrapper1").find(".wheel-scroll .wheel-item").eq(0).addClass("li_color");
				
				qs1.on('scrollEnd', () => {
					
					numStr2 = [];
					//滚动完成之后获取当前选取的索引值
					let index = qs1.getSelectedIndex();
			
					let codeIndex = $("#betterWrapper1").find(".wheel-scroll .wheel-item").eq(index).data("code");
					let name = ChineseDistricts[codeIndex];
					$(".betterContent2").css({"transform": "translateY(0)"})
					sanRender(name)
					
					city=$("#betterWrapper1").find(".wheel-scroll .wheel-item").eq(index).html();
			
					// 为当前索引添加样式
					$("#betterWrapper1").find(".wheel-scroll .wheel-item").eq(index).addClass("li_color");
					$("#betterWrapper1").find(".wheel-scroll .wheel-item").eq(index).siblings().removeClass("li_color");
				})
			}
			// 区
			function brtter_scroll3() {
				var wrapper2 = document.getElementById("betterWrapper2")
				qs2 = BetterScroll.createBScroll(wrapper2, {
					wheel: {
						selectedIndex: 0, //设置默认在哪个位置
						rotate: 5, //数据转动角度
						adjustTime: 400, //设置时间
						wheelWrapperClass: 'wheel-scroll',
						wheelItemClass: 'wheel-item',
					},
					observeDOM: false,
					mouseWheel: true,
					click:true,
					tap:true,
				})
				qs2.wheelTo(0);
				$("#betterWrapper2").find(".wheel-scroll .wheel-item").eq(0).addClass("li_color");
			
				qs2.on('scrollEnd', () => {
					//滚动完成之后获取当前选取的索引值
					let index = qs2.getSelectedIndex();
					area=$("#betterWrapper2").find(".wheel-scroll .wheel-item").eq(index).html();
					// 为当前索引添加样式
					$("#betterWrapper2").find(".wheel-scroll .wheel-item").eq(index).addClass("li_color");
					$("#betterWrapper2").find(".wheel-scroll .wheel-item").eq(index).siblings().removeClass("li_color");
				})
			}
			// 返回选择后的数据
			function ReturnData(data){
				return data;
			}
			// 对象转数组
			function dataArrty(val) {
				var arr = []
				for (let i in val) {
					arr.push({
						code: i,
						address: val[i]
					}); //属性
				}
				return arr
			}
		},
	}
	window.Star = window.Star || Star;
}(window))