window.onclick = hideContextMenu;
window.onkeydown = listenKeys;
	var contextMenu = document.getElementById('contextMenu');
	function showContextMenu(event) {
		alert("test");
		contextMenu.style.display = 'block';
		contextMenu.style.left=event.clientX + 'px';
		contextMenu.style.top=event.clientY + 'px';
		alert("test1");
		return false;
	}
	
	function hideContextMenu() {
		contextMenu.style.display = 'none';
	}
	
	function listenKeys(event){
		var keyCode = event.which || event.keyCode;
		if(keyCode ==  27){
			hideContextMenu();
		}
	}