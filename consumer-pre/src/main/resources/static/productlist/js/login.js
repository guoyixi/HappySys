(function(){document.write('<link rel="stylesheet" type="text/css" href="https://common.kaixinbao.com/release/www/PopDialog/v1.0/index.css">');if(document.location.href.indexOf("wj/shop/order_config_new!buyNow.action")>0||document.location.href.indexOf("wj/shop/underwriting_offline!init.action")>0||document.location.href.indexOf("wj/shop/order_config_new!buyNowUpdate.action")>0){try{if(loginFlag!="true"){reloadQr()}else{jQuery("#shop_login_mod").hide()}}catch(e){}}jQuery("#user-login").click(function(){var localURL=window.location.href;var loginBackURL=encodeURIComponent(localURL);var microServiceMemberDomain=jQuery("#microServiceMemberDomain").val().replace("https","http");PopDialog.login({title:"请登录",url:microServiceMemberDomain+"/pc/login/popup/init?showLoginbox=Y&loginBackURL="+loginBackURL,area:["350px","480px"],success:function(){jQuery("#shop_login_mod").hide();jQuery("#quick_2").show();loginAfterAppnt();jQuery.flushHeaderInfo();window.location.reload()}})});jQuery("#headerShowLoginWindow").click(function(){if(jQuery("#artLoginFlag").val()==1){artLoginNew()}else{var localURL=window.location.href;var loginBackURL=encodeURIComponent(localURL);window.location.href=sinosoft.httpsbase+"/shop/member!newLogin.action?tagid=logintag&loginBackURL="+loginBackURL}});jQuery("#shoplogin").click(function(){if(!checkCode()){return false}if(!checkShopUserName()){return false}if(!checkShopPassword()){return false}jQuery(this).addClass("login_londing");jQuery("#shoperror").html("");jQuery.getJSON(sinosoft.base+"/shop/member!artAjaxLoginDoamin.action?callback=?&loginName="+jQuery("#shoploginname").val()+"&loginPassword="+jQuery("#shoppass").val()+"&j_captcha="+jQuery("#shopCode").val(),function(data){if(data.status=="success"){gio("track","loginEvnet");jQuery("#shop_login").hide();artSuccessBack(data);jQuery("#shoploginname").val("");jQuery("#shoppass").val("")}else{loginCaptchaImageRefresh();jQuery("#shoplogin").removeClass("login_londing");jQuery("#shoperror").html(data.message);logqueryRemarkError()}});VL_Send("buylogin","","")});jQuery("#headerLogout").click(function(){jQuery.getJSON(sinosoft.base+"/shop/member!logoutAjax.action?callback=?",function(data){if(data&&data.status=="1"){jQuery.flushHeaderInfo();if(jQuery("#out_member")){var str=jQuery("#out_member").val();if(str=="member"){window.location.href=sinosoft.base+"/shop/member!newLogin.action"}}}else{jQuery.tip("退出异常!")}});if(typeof logoutAfterAppnt!="undefined"){logoutAfterAppnt()}var tConfirm=document.getElementById("comfirmToPay");if((null!=tConfirm)&&(""!=tConfirm)&&("undefined"!=typeof(tConfirm))){jQuery("#comfirmToPay").hide();jQuery("#comfirmToPay").siblings("em").hide();jQuery("#comfirmToPay").parent().addClass(" syr33")}var youhui_div=jQuery("#youhui_div");if((null!=youhui_div)&&(""!=youhui_div)&&("undefined"!=typeof(youhui_div))){youhui_div.hide()}var jifen_login_form=document.getElementById("jifen_login_form");if((null!=jifen_login_form)&&(""!=jifen_login_form)&&("undefined"!=typeof(jifen_login_form))){jifen_login_form.submit()}var integer_login=document.getElementById("integer_login");if((null!=integer_login)&&(""!=integer_login)&&("undefined"!=typeof(integer_login))){var riskcode_int=jQuery("#RiskCode").val();if(complicatedFlag=="Y"){compRecal(riskcode_int,"")}else{premDocal(riskcode_int)}jQuery("#integer_login").show();jQuery("#favorite").addClass("no_add_sc");jQuery("#favorite").html("<em></em>收藏")}if(window.location.href.indexOf("shop/order_config_new!sendDirectUrl")!=-1){jQuery(".integal_hjcon").hide();jQuery.getJSON(sinosoft.base+"/shop/sales_volume!pointInfo.action?orderSn="+orderSn+"&productId="+productId,function(data){if(data){jQuery("#result_sendPointsDesc").html(data.result_sendPointsDesc);jQuery("#result_sendPoints").html(data.result_sendPoints);jQuery("#result_sendPointsValue").html(data.result_sendPointsValue)}})}if(window.location.href.indexOf("shop/order_config_new!buyNow")!=-1||window.location.href.indexOf("shop/order_config_new!buyNowUpdate")!=-1||window.location.href.indexOf("shop/order_config_new!keepInput")!=-1){jQuery(".integal_hjcon").hide();if(pointExchangeFlag!="1"){var varPrice=document.getElementById("priceTotle").innerHTML;var cpsUserId=jQuery.cookie("cpsUserId");var channelsn="wj";if(typeof(cpsUserId)!="undefined"&&cpsUserId!=null&&cpsUserId!=""){channelsn="cps"}var insMult=jQuery("#insMult").text();jQuery.getJSON(sinosoft.base+"/shop/sales_volume!pointInfo.action?price="+varPrice+"&productId="+productId+"&channelsn="+channelsn+"&risktypeNum="+insMult,function(data){if(data){jQuery("#result_sendPointsDesc").html(data.result_sendPointsDesc);jQuery("#result_sendPoints").html(data.result_sendPoints);jQuery("#result_sendPointsValue").html(data.result_sendPointsValue)}})}}if(typeof logoutAfterMsg!="undefined"){logoutAfterMsg()}})})();function artLoginShopCart(){art.dialog.data("base",sinosoft.base);art.dialog.data("front",sinosoft.front);art.dialog.data("shopcarturl",sinosoft.base+"/shop/member_shopcart!getShopCartINF.action");art.dialog.open(sinosoft.front+"/block/art_login.shtml",{id:"loginArtWindow",title:"您尚未登录",width:"338px",height:"480px",fixed:true},false)}function artLogin(){art.dialog.data("base",sinosoft.base);art.dialog.data("front",sinosoft.front);art.dialog.data("tagid","");art.dialog.open(sinosoft.front+"/block/art_login.shtml",{id:"loginArtWindow",title:"您尚未登录",width:"338px",height:"480px",fixed:true},false)}function artLoginNew(){var localURL=window.location.href;var loginBackURL=encodeURIComponent(localURL);var microServiceMemberDomain=jQuery("#microServiceMemberDomain").val().replace("https","http");PopDialog.login({title:"请登录",url:microServiceMemberDomain+"/pc/login/popup/init?loginBackURL="+loginBackURL,area:["350px","480px"],success:function(){jQuery("#shop_login_mod").hide();jQuery("#quick_2").show();jQuery.flushHeaderInfo();window.location.reload()}})}function artRegister(){art.dialog.data("base",sinosoft.base);art.dialog.data("front",sinosoft.front);art.dialog.data("tagid","regtag");art.dialog.open(sinosoft.front+"/block/art_login.shtml",{id:"loginArtWindow",title:"您尚未登录",width:"338px",height:"480px",fixed:true},false)}function artNewLogin(){art.dialog.data("base",sinosoft.base);art.dialog.data("front",sinosoft.front);art.dialog.data("tagid","regtag");art.dialog.open(sinosoft.front+"/block/art_login.shtml",{id:"loginArtWindow",title:"您尚未登录",width:"338px",height:"480px",fixed:true},false)}function artLogin_other(frontPath){art.dialog.data("base",sinosoft.base);art.dialog.data("front",sinosoft.front);art.dialog.open(frontPath+"template/art_login.shtml",{id:"loginArtWindow",title:"登录窗口",width:362,height:389},false)}function artSuccessBack(data){jQuery.flushHeaderInfo();var redirectionUrl=jQuery.cookie("redirectionUrl");if(redirectionUrl!=null&&redirectionUrl!=""){location.href=redirectionUrl}var tCommentUser=document.getElementById("CommentUser");if((null!=tCommentUser)&&("undefined"!=typeof(tCommentUser))){tCommentUser.innerHTML=jQuery.cookie("loginMemberUsername");tCommentUser.title=jQuery.cookie("loginMemberUsername")}var trevw10cont02=document.getElementById("revw10cont02");if((null!=trevw10cont02)&&("undefined"!=typeof(trevw10cont02))){trevw10cont02.style.display="";document.getElementById("revw10cont01").style.display="none"}var tConfirm=document.getElementById("comfirmToPay");if((null!=tConfirm)&&(""!=tConfirm)&&("undefined"!=typeof(tConfirm))){jQuery("#comfirmToPay").show();jQuery("#comfirmToPay").siblings("em").show();jQuery("#comfirmToPay").parent().removeClass(" syr33")}if(typeof loginAfterAppnt!="undefined"){loginAfterAppnt();moreQuicklist()}if(typeof payLoginAfterAppnt!="undefined"){payLoginAfterAppnt()}if(typeof loginAfterMsg!="undefined"){loginAfterMsg()}var url=window.location.href;if(url.indexOf("shop/order_config_new!sendDirectUrl")!=-1){window.location.reload()}if(url.indexOf("/jifen/")!=-1){if(url.substr(url.length-7)=="/jifen/"){window.location.reload()}}if(url.indexOf("shop/points!integralMall.action")!=-1){window.location.reload()}if(url.indexOf("shop/order_config_new!buyNow")!=-1){if(pointExchangeFlag!="1"){ajaxAlreadySave(data.memberid)}}if(window.location.href.indexOf("shop/order_config_new!buyNow")!=-1||window.location.href.indexOf("shop/order_config_new!buyNowUpdate")!=-1||window.location.href.indexOf("shop/order_config_new!keepInput")!=-1){if(pointExchangeFlag!="1"){var varPrice=document.getElementById("priceTotle").innerHTML;var cpsUserId=jQuery.cookie("cpsUserId");var channelsn="wj";if(typeof(cpsUserId)!="undefined"&&cpsUserId!=null&&cpsUserId!=""){channelsn="cps"}var insMult=jQuery("#insMult").text();jQuery.getJSON(sinosoft.base+"/shop/sales_volume!pointInfo.action?price="+varPrice+"&productId="+productId+"&channelsn="+channelsn+"&risktypeNum="+insMult,function(data){if(data){if(data.inspageone_pointsInfo!=""){jQuery(".integal_hjcon").show();jQuery(".integral_hj").html(data.inspageone_pointsInfo)}jQuery("#result_sendPointsDesc").html(data.result_sendPointsDesc);jQuery("#result_sendPoints").html(data.result_sendPoints);jQuery("#result_sendPointsValue").html(data.result_sendPointsValue)}})}}var integer_login=document.getElementById("integer_login");if((null!=integer_login)&&(""!=integer_login)&&("undefined"!=typeof(integer_login))){var riskcode_int=jQuery("#RiskCode").val();if(complicatedFlag=="Y"){compRecal(riskcode_int,"")}else{premDocal(riskcode_int)}jQuery("#integer_login").hide();initFavorites()}var sem_list=document.getElementById("sem_list");if((null!=sem_list)&&(""!=sem_list)&&("undefined"!=typeof(sem_list))){initSemFavorites()}}function initFavorites(){var RiskCode=jQuery("#RiskCode").val();jQuery.ajax({type:"get",url:sinosoft.front+"/wj/shop/favorites!initFavorites.action?productId="+RiskCode,dataType:"html",success:function(de){if(de=="0"){jQuery("#favorite").addClass("no_add_sc");jQuery("#favorite").html("<em></em>收藏")}else{jQuery("#favorite").removeClass("no_add_sc");jQuery("#favorite").html("<em></em>已收藏")}}});window.submitp=function(str){jQuery.ajax({type:"get",url:sinosoft.front+"/wj/shop/favorites!add.action?productId="+str,dataType:"html",success:function(de){if(de=="notlogin"){artLoginNew()}else{art.dialog.alert(de);jQuery("#favorite").removeClass("no_add_sc");jQuery("#favorite").html("<em></em>已收藏")}}})}}function artContentBack(data){jQuery.flushHeaderInfo()}var localURL=window.location.href;var loginBackURL=encodeURIComponent(localURL);function otherLogin(comCode,source){if(comCode=="tencent"){if(source!=null&&source!=""){VL_Send(source,"","")}window.location.href="/wj/shop/tencent_login!aouth.action?loginBackURL="+loginBackURL}else{if(comCode=="sina"){if(source!=null&&source!=""){VL_Send(source,"","")}window.location.href="/wj/shop/sina_login!aouth.action?loginBackURL="+loginBackURL}else{if(comCode=="alipay"){if(source!=null&&source!=""){VL_Send(source,"","")}window.location.href="/wj/shop/alipay_login!aouth.action?loginBackURL="+loginBackURL}}}}function checkShopUserName(){var userName=jQuery("#shoploginname").val();var myReg=/^[-_A-Za-z0-9\.]+@([-_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,4}$/;var regu=/^[1][2-9][0-9]{9}$/;if(userName==null||userName==""){jQuery("#shoperror").html("用户名不能为空哟");return false}if(userName!=null&&userName!=""&&!myReg.test(userName)&&!regu.test(userName)){jQuery("#shoperror").html("正确的邮箱或手机号是登录的唯一凭证哟");return false}return true}function checkShopPassword(){var regPass=jQuery("#shoppass").val();if(regPass.length<6||regPass.length>16){jQuery("#shoperror").html("您的密码太短了，灰常不安全");return false}else{if(regPass.indexOf(" ")!=-1){jQuery("#shoperror").html("密码是不能填写空格的，改一下吧");return false}else{return true}}}function checkCode(){if(jQuery("#shopCode").is(":visible")){var userCode=jQuery("#shopCode").val();if(userCode==null||userCode==""){jQuery("#shoperror").html("验证码不能为空哟");return false}else{return true}}else{return true}}function ajaxAlreadySave(memberid){jQuery.ajax({url:sinosoft.base+"/shop/order_config_new!ajaxAlreadySave.action?productId="+productId+"&memberid="+memberid,dataType:"json",async:false,success:function(data){var obj=eval(data);if(obj.status=="1"){var content="<p>您于"+obj.date+"日暂存过此保单<br>是否继续填写上次暂存结果</p>";if(obj.isoverdue=="0"){content+='<p style="color:red;">（保单已过期，填入可修改）</p>'}art.dialog({title:"温馨提示",content:content,button:[{name:"自动填写",callback:function(){window.location.href=sinosoft.base+obj.fillUrl},focus:true},{name:"不用",callback:function(){this.close();return false}}]})}}})}function loginCaptchaImageRefresh(){document.getElementById("loginCaptchaImage").setAttribute("src",sinosoft.base+"/captcha.jpg?timestamp"+(new Date()).valueOf())}function logqueryRemarkError(){jQuery.ajax({url:sinosoft.base+"/shop/member!queryLoginRemark.action",type:"post",dataType:"json",success:function(data){if(data==false){jQuery("#logveriCode").show();jQuery("#shopCode").val("")}}})}$("#loginCaptchaImage").click(function(){loginCaptchaImageRefresh()});function qrLogin(uuid){var mythis=this;jQuery.ajax({url:jQuery("#microServiceMemberDomain").val().replace("https","http")+"/pc/login/popup/qr",type:"post",dataType:"json",timeout:600000,async:true,data:{uuid:uuid},success:function(data){if(data.status=="0"){var openId=data.data;window.location.href=jQuery("#microServiceMemberDomain").val()+"/thirdLogin/qrLogin.shtml?openId="+openId+"&&loginBackURL="+encodeURIComponent(window.location.href)}else{reloadQr()}},error:function(XMLHttpRequest,textStatus,errorThrown){reloadQr()}})}function reloadQr(){jQuery.ajax({url:jQuery("#microServiceMemberDomain").val().replace("https","http")+"/pc/login/popup/getQr",type:"post",dataType:"json",timeout:40000,async:true,data:{uuid:""},success:function(data){if(data.status=="0"){var qrUrl=data.data.qrUrl;$("#imgQrUrl").attr("src",qrUrl);qrLogin(data.data.uuid)}else{window.location.reload}},error:function(XMLHttpRequest,textStatus,errorThrown){art.dialog.alert("二维码超时，请重新刷新页面！")}})};