<#import "path/common.ftl" as c>
<#import "path/weather_info_page.ftl" as w>

<@c.page>
    <@w.weather_component "/weatherstack", "stack" />
</@c.page>