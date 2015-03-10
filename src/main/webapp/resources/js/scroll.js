/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){ 
      var MAX_IMAGE = 50;
      var ALL_IMAGE = true;
      
      var load = false;
      var loaded_image = -1;
      var total_image = 0;
      $(window).scroll(function(){ 
              console.log($(document).height() - $(window).height() - 10);
              console.log($(window).scrollTop());
              if(($(document).height() - $(window).height() - 220) <= $(window).scrollTop()
                  && !load && loaded_image != 0 &&  (ALL_IMAGE || total_image < MAX_IMAGE)){
                console.log("End Reached");
                var last_id = $('.image:last').attr('id');
                load = true;
                $.ajax({
                        url: '/upemgur/LoadImageServlet',
                        type: 'get',
                        dataType: 'json',
                        data: {img_id : last_id},
                        //Succès de la requête
                        success: function(data) {
                            console.log(data);
                            var out ='';
                            for(var i=0; i < data.images.length; i++) {
                                out += '<a class="image" id="'+data.images[i].id+'" href="image.xhtml?img_id='+data.images[i].id+'">';
                                out += '<img alt="'+data.images[i].title+'" src="/upemgur/images/'+data.images[i].filename+'" />';
                                out += '</a>';
                            }
                            load = false;
                            loaded_image = data.images.length;
                            total_image += loaded_image;
                            if(loaded_image == 0)
                                return;
                            $('.image:last').after(out);
                        }
                });
                
                $(".image-container").justifiedGallery('norewind');
              }
        });
        /*
        <a class="image" id="2" href="image.xhtml?img_id=2">
           <img alt="l" src="/upemgur/images/5432167835001264671.jpg" />
        </a>
    
        {
        "images" : [{"id": 1, "title":"test","filename": "13e5d446.jpg"},
                    {"id": 1, "title":"test","filename": "13e5d446.jpg"},
                    {"id": 1, "title":"test","filename": "13e5d446.jpg"}]
        }
        */
});
