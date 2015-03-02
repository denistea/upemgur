$(document).ready(function(){
    /*$('.image-container').empty().justifiedImages({
        images :    [{"url_s": "file:///C:/Users/Miguel/Desktop/Upemgur/images/sample/1.jpg",
                  "width_s": "550" ,
                  "height_s": "412"}],
        rowHeight: 200,
        maxRowHeight: 400,
        thumbnailPath: function(photo, width, height){
            var purl = photo.url_s;
            if( photo.url_n && (width > photo.width_s * 1.2 || height > photo.height_s * 1.2) ) purl = photo.url_n;
            if( photo.url_m && (width > photo.width_n * 1.2 || height > photo.height_n * 1.2) ) purl = photo.url_m;
            if( photo.url_z && (width > photo.width_m * 1.2 || height > photo.height_m * 1.2) ) purl = photo.url_z;
            if( photo.url_l && (width > photo.width_z * 1.2 || height > photo.height_z * 1.2) ) purl = photo.url_l;
            return purl;
        },
        getSize: function(photo){
            return {width: photo.width_s, height: photo.height_s};
        },
        margin: 1
    });*/
    $(".image-container").justifiedGallery({
        rowHeight : 200,
        margins : 3,
        fixedHeight : true,
        captionSettings : { animationDuration : 100,
                            visibleOpacity : 0.7,
                            nonVisibleOpacity : 0.0}
    });
});