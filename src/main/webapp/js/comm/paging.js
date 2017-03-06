/*!************************************************************************************
 * jQuery Paging 0.2.1
 * by composite (ukjinplant@msn.com)
 * http://hazard.kr
 * This project licensed under a MIT License.
 **************************************************************************************/;

 /*!************************************************************************************
 
  jQuery를 위한 간단한 페이징.

	사용법 : 	$('#paging').paging({max:50});
			$(‘#paging’).paging({current:5,max:50});
	
	속성 :
	item : 페이징 요소 태그명, 기본값 "a".
	itemClass : 페이징 요소 중 페이지 수 CSS 클래스, 기본값 "paging-item".
	itemCurrent : 현재 페이지를 나타내는 CSS 클래스이며 페이징 요소와 중첩됨, 기본값 "selected".
	format : 페이지를 나타낼 내용, 기본값 "[%d]".
	sideClass : 다음 또는 이전 버튼 CSS 클래스, 기본값 "paging-side".
	next : 다음 버튼 내용. 기본값 "[{5}&gt;]" ("[>]")
	prev : 이전 버튼 내용. 기본값 "[{4}&lt;]" ("[<]")
	first : 첫 페이지 내용. 기본값 "[1&lt;&lt;]"
	last : 마지막 페이지 내용. 기본값 "[&gt;&gt;{6}]"
	length : 페이지 표시할 개수. 기본값 10.
	max : 최대 표현할 페이지 수. 기본값 1.
	current : 현재 페이지 정의. 기본값 1.
	href : a 태그일 때 링크 주소를 정의. 기본값 "#%d"
	append : true 설정 시, 기존 내용을 삭제하지 않고 페이징을 포함시킴. 기본값 false.
	
	event : 기본 이벤트 활성화. 새로고침 없이 동적으로 페이징 초기화됨. ajax에 유용. 기본값 true.
	>event=true 일 때 가능한 이벤트 정의.
	
	onclick : 페이징 버튼 클릭 시 호출. false 반환 시 동적으로 페이지가 바뀌지 않음. 동적 페이징을 원하지만
	          href로 인한 링크 이동을 원하지 않을 경우 이벤트 메서드인 event.stopPropagation() 호출.
	onprev : 이전 버튼 초기화 시 이벤트. 'this' 는 이전 버튼 요소를 가리킴.(plain DOM. not jQuery!)
	onnext : 다음 버튼 초기화 시 이벤트. 'this' 는 다음 버튼 요소를 가리킴.(plain DOM. not jQuery!)
	onitem : 각 페이지 버튼 초기화 시 이벤트. 'this' 는 각 페이지 버튼 요소를 가리킴.
	
	치환자 (format,next,prev,href,first,last 속성 전용)
	{0} = 클릭 시 페이지
	{1} = 페이지 길이
	{2} = 처음 페이지
	{3} = 마지막 페이지
	{4} = 이전 파트의 마지막 페이지
	{5} = 다음 파트의 처음 페이지
	{6} = 맨 마지막 페이지
   
  **************************************************************************************/;
 
!function($){
	'use strict';
	//default properties.
	var a=/a/i,defs={
		item:'a',next:'[&gt;{5}]',prev:'[{4}&lt;]',format:'[{0}]',
		itemClass:'paging-item',sideClass:'paging-side',className:'jquery-paging',
		itemCurrent:'selected',length:10,max:1,current:1,append:false
		,href:'#{0}',event:true,first:'[1&lt;&lt;]',last:'[&gt;&gt;{6}]'
	},format=function(str){
		var arg=arguments;
		return str.replace(/\{(\d+)}/g,function(m,d){
			if(+d<0) return m;
			else return arg[+d+1]||"";
		});
	},item,make=function(op,page,cls,str){
		item=document.createElement(op.item);
		item.className=cls;
		item.innerHTML=format(str,page,op.length,op.start,op.end,op.start-1,op.end+1,op.max);
		if(a.test(op.item)) item.href=format(op.href,page);
		if(op.event){
			$(item).bind('click',function(e){
				var fired=true;
				if($.isFunction(op.onclick)) fired=op.onclick.call(item,e,page,op);
				if(fired==undefined||fired)
					$(op.origin).paging({current:page});
				return fired;
			}).appendTo(op.origin);
			//bind event for each elements.
			var ev='on';
			switch(str){
				case op.prev:ev+='prev';break;
				case op.next:ev+='next';break;
				case op.first:ev+='first';break;
				case op.last:ev+='last';break;
				default:ev+='item';break;
			}
			if($.isFunction(op[ev])) op[ev].call(item,page,op);
		}
		return item;
	};

	$.fn.paging=function(op){
		$(this).each(function(){
			if(this.__JQ_PAGING){
				if(op === 'destroy'){
					$(this).removeClass(this.__JQ_PAGING.className).empty();
					delete this.__JQ_PAGING;
					return true;
				}else if(op in this.__JQ_PAGING){
					return this.__JQ_PAGING[op];
				}
				op=$.extend(this.__JQ_PAGING,op||{});$(this).empty();
			}else if(op instanceof String || typeof op === 'string') return false;
			else{
				op=$.extend({origin:this},defs,op||{});
				$(this).addClass(op.className).empty();
			}
			if(op.max<1) op.max=1; if(op.current<1) op.current=1;
			op.start=~~((op.current-1)/op.length)*op.length+1;
			op.end=op.start-1+op.length;
			if(op.end>op.max) op.end=op.max;
			if(op.current>op.length){
				if(op.first!==false) make(op,1,op.sideClass,op.first);//first button
				make(op,op.start-1,op.sideClass,op.prev);//prev button
			}
			//pages button
			for(var i=op.start;i<=op.end;i++)
				make(op,i,op.itemClass+(i==op.current?' '+op.itemCurrent:''),op.format);

			if(op.current/op.length<op.max/op.length){
				if(op.end<op.max) make(op,op.end+1,op.sideClass,op.next);//next button
				if(op.last!==false) make(op,op.max,op.sideClass,op.last);//last button
			}
			this.__JQ_PAGING=op;
		});
	};
}(jQuery);