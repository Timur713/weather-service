<#macro weather_component action_url header_suffix>
    <div style="display: inline">
        <a href="/" class="btn btn-dark" type="submit">back</a>
        <h1 id="weather_header">Weather<span style="color: #da1e27">stack</span> service</h1>
    </div>

    <form action="${action_url}" method="post" class="mt-5" id="weather_form">
        <div id="weather_form_components">
            <div class="form-group row">
                <label for="city" class="col-sm-2 col-form-label">City: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="city" name="city"
                           value="<#if response_lastRequestCityName??>${response_lastRequestCityName}<#else></#if>">
                </div>
            </div>
            <fieldset class="form-group">
                <div class="row">
                    <legend class="col-form-label col-sm-2 pt-0">Parameters:</legend>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="temperature" id="temperature"
                                   <#if response_temperature??>checked</#if>>
                            <label class="form-check-label" for="temperature">
                                Temperature
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="windSpeed" id="windSpeed"
                                   <#if response_windSpeed??>checked</#if>>
                            <label class="form-check-label" for="windSpeed">
                                Wind speed
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="pressure" id="pressure"
                                   <#if response_pressure??>checked</#if>>
                            <label class="form-check-label" for="pressure">
                                pressure
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="humidity" id="humidity"
                                   <#if response_humidity??>checked</#if>>
                            <label class="form-check-label" for="humidity">
                                humidity
                            </label>
                        </div>
                        <#if header_suffix=="api">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" name="cloud" id="cloud"
                                       <#if response_cloud??>checked</#if>>
                                <label class="form-check-label" for="cloud">
                                    cloud
                                </label>
                            </div>
                        </#if>
                    </div>
                </div>
            </fieldset>

            <button type="submit" class="btn btn-info">Get info</button>
        </div>
    </form>

    <#if response_lastRequestCityName??>
        <div class="mt-5" id="weather_response_content">
            <p>Your city: ${response_lastRequestCityName}</p>

            <#if response_temperature??>
                <p>Temperature: ${response_temperature}</p>
            </#if>
            <#if response_windSpeed??>
                <p>Wind speed: ${response_windSpeed}</p>
            </#if>
            <#if response_pressure??>
                <p>Pressure: ${response_pressure}</p>
            </#if>
            <#if response_humidity??>
                <p>Humidity: ${response_humidity}</p>
            </#if>
            <#if header_suffix=="api">
                <#if response_cloud??>
                    <p>Cloud: ${response_cloud}</p>
                </#if>
            </#if>
        </div>
    </#if>

    <#if response_cityError??>
        <div class="alert alert-danger mt-5" role="alert">
            ${response_cityError}
        </div>
    </#if>
</#macro>