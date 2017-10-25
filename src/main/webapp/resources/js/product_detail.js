/**
 * 
 */

var $descriptiontop = $("#description-top"),
	$descriptionbottom = $("#description-bottom"),
	str1 = $("#description-top-input").val(),
	str2 = $("#description-bottom-input").val(),
	html1 = $.parseHTML(str1),
	html2 = $.parseHTML(str2);

	$descriptiontop.append(html1);
	$descriptionbottom.append(html2);
		