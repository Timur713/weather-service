<#import "path/common.ftl" as c>

<@c.page>
    <h2>Hello, guest</h2>
    <form action="/" method="post">

        <div class="form-inline mt-5">
            <label for="services"><h5>Choose service:</h5></label>
            <select class="form-control ml-5" id="services" name="service">
                <option value="weatherstack" selected>Weatherstack</option>
                <option value="weatherapi">Weatherapi</option>
            </select>
            <button type="submit" class="btn btn-primary ml-5">Select</button>
        </div>
    </form>
</@c.page>