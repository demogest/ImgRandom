# Intro

​	In order to get random cover, I have written a tool to return random image each request. This tool is open-sourced on [ImgRandom](https://github.com/demogest/ImgRandom). This tool is written in Java with Spring Boot.



# Usage

**API:**

​		https://image.firmant.me/random?

**Parameters:**

<table>
    <tr>
        <th text-align="center">name</th>
        <th text-align="center">value</th>
        <th text-align="center">comment</th>
    </tr>
    <tr>
        <td rowspan="2" text-align="center">type</td>
        <td text-align="center">pc</td>
        <td text-align="center">use for horizontal</td>
    </tr>
    <tr>
        <td text-align="center">mp</td>
        <td text-align="center">use for vertical</td>
    </tr>
</table>

**Examples:**

1. Get image fit for pc
    - url: https://image.firmant.me/random?type=pc
    - method: Get
    - result:![pcImage](https://image.firmant.me/random?type=pc)
2. Get image fit for mobile
    - url: https://image.firmant.me/random?type=mp
    - method: Get
    - result:![mpImage](https://image.firmant.me/random?type=mp)



# Dev

All dependencies are listed in *pom.xml*, I'm highly recommend you to use Java 11 or newer.

You can find the environment variables in the *application.properties*

This website is deployed by the reverse proxy of NGINX.