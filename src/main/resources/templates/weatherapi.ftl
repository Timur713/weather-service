<#import "path/common.ftl" as c>
<#import "path/weather_info_page.ftl" as w>

<@c.page>
    <@w.weather_component "/weatherapi", "api" />
</@c.page>