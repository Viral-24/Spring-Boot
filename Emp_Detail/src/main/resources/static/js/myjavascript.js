/**
 * 
 */
$(document).ready(function()
{
	$('#fileimage').change(function(){
		showImageThumbnail(this);
		});
				
	function showImageThumbnail(fileinput){
		file=fileinput.files[0];
		reader=new FileReader();
		reader.onload=function(e){
				$('#thumbnail').attr('src',e.target.result);
				};
				reader.readAsDataURL(file);
				}   
				
	$('#fileimage').change(function(event) {
		var vaildExt=["jpeg","png","jpg"];
		var img_ext=fileimage.value.substring(fileimage.value.lastIndexOf('.')+1);
		var result=vaildExt.includes(img_ext);
			if(result==false){ 
				alert("The Slected File should 'jpeg', 'png', 'jpg' ");
					return false;
			}
			else{
				if(parseFloat(fileimage.files[0].size/(1024*1024))>=0.2){ 
					alert("The Size of file should be less then 200 KB");
					document.getElementById('fileimage').value = ""; 
					return false;
					}	
				}
			return true;
		});
	
	
		       
});