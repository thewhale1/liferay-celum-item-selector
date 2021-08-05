<%@ include file="/init.jsp" %>

<%
ItemSelectorCelumViewDisplayContext itemSelectorCelumViewDisplayContext = (ItemSelectorCelumViewDisplayContext)request.getAttribute(ItemSelectorCelumView.ITEM_SELECTOR_CELUM_VIEW_DISPLAY_CONTEXT);
ItemSelectorReturnTypeResolver<?, ?> itemSelectorReturnTypeResolver = itemSelectorCelumViewDisplayContext.getItemSelectorReturnTypeResolver();
Class<?> itemSelectorReturnTypeClass = itemSelectorReturnTypeResolver.getItemSelectorReturnTypeClass();
%>
<br/></br>
<div class="container-fluid container-fluid-max-xl">
	<div class="drop-enabled drop-zone item-selector upload-view">
		<div id="uploadDescription">
			<p>
				<button type="button" class="btn btn-secondary" onclick="displayCelumAssetSelector();"><liferay-ui:message key="celum-select-asset" /></button>
			</p>
		</div> 
	</div> 
	
	<br/>
	<br/>
	
	<div>
		<liferay-frontend:vertical-card cssClass="article-preview-content" imageUrl="https://via.placeholder.com/150" title="Sample Card">
			<liferay-frontend:vertical-card-sticker-bottom>
				
			</liferay-frontend:vertical-card-sticker-bottom>
	
			  <liferay-frontend:vertical-card-footer>
			    
	  		</liferay-frontend:vertical-card-footer>
	  		
		</liferay-frontend:vertical-card>
	</div>
	<br/>
	<br/>
	
	<!-- TODO: Only show this button if assets were selected -->
	<div style="text-align: right;">
		<button type="button" class="btn btn-primary" onclick="chooseFile();"><liferay-ui:message key="celum-choose-file" /></button>
	</div>
</div>  

<script>
	var myWindow;
	
	function chooseFile(event) {
		
		console.log('Mocking the call to return the select File Entry');
        
        Liferay.fire(
		        'ITEM_SELECTOR_CELUM_VIEW_DISPLAY_CONTEXT',
		        {
		            data:{

		                'fileEntryId': 35767,
		                'groupId': 20121,
		                'title': 'pexels-eberhard-grossgasteiger-844297.jpg ',
		                'url': 'http://localhost:8080/documents/20121/0/pexels-eberhard-grossgasteiger-844297.jpg/2197af36-a775-7b6d-51a2-57e5937f019d?t=1628116364948',
		                'uuid': ''
		            }
		        } 
		);
		
	}
	 
	// This function opens a new window to the CELUM Asset Selector
	// TODO: 
		// 1. Remove hardcoded options and fetch them from the configuration
		// 2. Generate a security token and pass it along to protect the callback
	function displayCelumAssetSelector(event) {
		var baseUrl = "http://celumdemo.avyre.com:8880/external/login.do?"
		var sessionId=randomSessionId();
		var passthroughParameters = encodeURIComponent('userId='+Liferay.ThemeDisplay.getUserId()+'&groupId='+Liferay.ThemeDisplay.getScopeGroupId()+'&companyId='+Liferay.ThemeDisplay.getCompanyId());
	  	myWindow = window.open(baseUrl+"&application=liferaysingle&session="+sessionId+"&passthrough="+passthroughParameters, "CELUM Asset Select", 'height=800,width=1200,scrollbars=yes,status=no,location=no,');
	  	
	  	var timer = setInterval(function() {
			if(myWindow.closed) {
				clearInterval(timer);
				Liferay.Util.getOpener().Liferay.fire('<%= itemSelectorCelumViewDisplayContext.getItemSelectedEventName() %>', event);
			}
		}, 500);
	}
	
	// This function is a temporary function to mock a session id
	function randomSessionId() {
		return Math.random().toString(36).substring(2, 15)+"_"+Liferay.ThemeDisplay.getCompanyId()+"_"+Liferay.ThemeDisplay.getScopeGroupId()+"_"+Liferay.ThemeDisplay.getUserId();
	}
</script>