/**
 * 
 */

 $(document).ready(function(){
    $('.table .eBtn').on('click', function (event) {        
        event.preventDefault();
        var selectedPortraitImage = $(this).attr('href');

        $.get(selectedPortraitImage, function(image, status){
            $('.modalForm #modal-image-id').val(image.portraitImageId);
            $('.modalForm #modal-image-name').val(image.name);
        });

        $('.modalForm #portraitImageModal').modal();        
    });
 });