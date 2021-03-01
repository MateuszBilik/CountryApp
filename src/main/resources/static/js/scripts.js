let form = document.forms['location']
let country = form['country'];
let city = form['city'];
const tableBody = document.querySelector('.tbody');

function buttonFind(event) {
    event.preventDefault();
    console.log('user written: country: ' + country.value + " city: " + city.value);

    var x;
    fetch("http://localhost:8080/city?country=" + country.value.toLowerCase() + '&city=' + city.value.toLowerCase())
        .then(response => response.json())
        .then(cityInfo => {

            if (cityInfo.status != 500) {
                tableBody.innerHTML = `

    <div class="row ">
        <div class="col-md-7 ">
            <div class="panel panel-default">
                <div class="panel-heading"><h4>${cityInfo.country.name}</h4></div>
                <div class="panel-body">
                    <div class="box box-info">
                        <div class="box-body">
                            <div class="col-sm-6">
                                <div align="center"><img alt="User Pic" src="` + cityInfo.country.flagUrl + `"
                                                         id="profile-image1" style="border-radius: 10px;">

                                </div>
                                <br>
                                <!-- /input-group -->
                            </div>
                            <div class="col-sm-6">
                                <h4 style="color:#00b1b1;">${cityInfo.name}</h4></span>
                            </div>
                            <div class="clearfix"></div>
                            <hr style="margin:5px 0 5px 0;">

                            <div class="col-sm-5 col-xs-6 tital">Currency:</div>
                            <div class="col-sm-7 col-xs-6 ">${cityInfo.country.currency}</div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Exchange rate:</div>
                            <div class="col-sm-7">${cityInfo.country.exchangeRate}</div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Localization:</div>
                            <div class="col-sm-7">${cityInfo.latitude}</div>
                            <div class="col-sm-7">${cityInfo.longitude}</div>
                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-7 ">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h4>Weather:</h4></div>
                        <div class="panel-body">
                            <div class="box box-info">
                                <div class="box-body">

                                    <div class="col-sm-5 col-xs-6 tital ">Description:</div>
                                    <div class="col-sm-7">${cityInfo.weather.description}</div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>

                                    <div class="col-sm-5 col-xs-6 tital ">Temperature:
                                    </div
                                    >
                                    <div class="col-sm-7">${cityInfo.weather.temperature}°C</div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>

                                    <div class="col-sm-5 col-xs-6 tital ">Feels like:</div>
                                    <div class="col-sm-7">${cityInfo.weather.sensedTemp}°C</div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>

                                    <div class="col-sm-5 col-xs-6 tital ">Pressure:</div>
                                    <div class="col-sm-7">${cityInfo.weather.pressure} hPa</div>
                                    <div class="clearfix"></div>
                                    <div class="bot-border"></div>

                                    <div class="col-sm-5 col-xs-6 tital ">Wind:</div>
                                    <div class="col-sm-7">${cityInfo.weather.wind}m/s</div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="container">
                    <div class="row">
                        <div class="col-md-7 ">
                            <div class="panel panel-default">
                                <div class="panel-heading"><h4>Other:</h4></div>
                                <div class="panel-body">
                                    <div class="box box-info">
                                        <div class="box-body">

                                            <div class="col-sm-5 col-xs-6 tital ">Id Country:</div>
                                            <div class="col-sm-7">${cityInfo.country.wikiId}</div>
                                            <div class="clearfix"></div>
                                            <div class="bot-border"></div>

                                            <div class="col-sm-5 col-xs-6 tital ">Id city:</div>
                                            <div class="col-sm-7">${cityInfo.id}</div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
`;
                console.log('Created table');
            } else {
                console.log('error');
                tableBody.innerHTML = `
                <div style="color:red; float:right">
                There isn't that location, try again.
                </div>
                `
            }
        })


};

form.addEventListener('submit', buttonFind)


