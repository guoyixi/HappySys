var Toast=function(config){this.context=config.context==null?$("body"):config.context;this.message=config.message;this.time=config.time==null?10000:config.time;this.left=config.left;this.top=config.top;this.init()};var msgEntity;Toast.prototype={init:function(){$("#toastMessage").remove();var msgDIV=new Array();msgDIV.push('<div id="toastMessage">');msgDIV.push("<span>"+this.message+"</span>");msgDIV.push("</div>");msgEntity=$(msgDIV.join("")).appendTo(this.context);var left=this.left==null?this.context.width()/2-msgEntity.find("span").width()/2:this.left;var top=this.top==null?this.context.scrollTop()+this.context.height()/2-msgEntity.find("span").height()/2:this.top;msgEntity.css({position:"absolute",top:top,"z-index":"99",left:left,"background-color":"#443A30",color:"white","font-size":"1.5em;",padding:"10px",margin:"0px"});msgEntity.hide()},show:function(){msgEntity.fadeIn(this.time/10);msgEntity.fadeOut(this.time/10)}};function showError(error){new Toast({context:$("body"),message:error}).show()}function uaredirect(murl,type){try{if(document.getElementById("bdmark")!=null){return}var urlhash=window.location.hash;if(!urlhash.match("fromapp")){if((navigator.userAgent.match(/(iPhone|iPod|Android|ios|iPad)/i))){var cpsUserId=getLocalCookie("cpsUserId");var cpstype=getLocalCookie("cpsUserSource");if(typeof(cpsUserId)!="undefined"&&cpsUserId!=null&&cpsUserId!=""&&cpsUserId!="undefined"){if(type=="home"){if(cpstype=="AGENT"){murl+="?cpsSource=11&channeCode=05&cpsUserCode="+cpsUserId}else{murl+="?cpsSource=12&channeCode=05&cpsUserCode="+cpsUserId}}else{if(type=="list"||type=="detail"){if(cpstype=="AGENT"){murl+="&CPSSource=11&CPSUserID="+cpsUserId}else{murl+="&CPSSource=12&CPSUserID="+cpsUserId}}}}location.replace(murl)}}}catch(err){alert(err)}}function getLocalCookie(objname){var arrstr=document.cookie.split("; ");for(var i=0;i<arrstr.length;i++){var temp=arrstr[i].split("=");if(temp[0]==objname){return unescape(temp[1])}}};