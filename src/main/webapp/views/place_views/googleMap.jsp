<
<html>
<head>


    <script
            src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
    <script>
        var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
        var labelIndex = 0;

        var map;
        function initialize() {
            var mapOptions = {
                zoom: 10,
                center: new google.maps.LatLng(56.9383005, 24.1242021)
            };
            map = new google.maps.Map(document.getElementById('map-canvas'),
                    mapOptions);

            var myLatLng = {lat: 56.7, lng: 24.1};
            var image = 'images/beachflag.png';
            var marker = new google.maps.Marker({
                position: myLatLng,
                map: map,
                icon:image,
                title: 'Hello World!'


            });





            }



        google.maps.event.addDomListener(window, 'load', initialize);


    </script>
</head>
<body>
<div id="map-canvas" style="height:400px; width:700px"></div>
</body>
</html>
