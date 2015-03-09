/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){ 
    
      var load = false; 
      $(window).scroll(function(){ 
              console.log($(document).height() - $(window).height() - 10);
              console.log($(window).scrollTop());
              if(($(document).height() - $(window).height() - 220) <= $(window).scrollTop()
                  && !load){
                console.log("End Reached");
                var last_id = $('.image:last').attr('id');
                load = true;
                $.ajax({
                        url: '/upemgur/LoadImageServlet',
                        type: 'get',
                        data: {img_id : last_id},

                        //Succès de la requête
                        success: function(data) {
                            console.log(data);
                            $('.image:last').after(data);
                            load = false;
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
