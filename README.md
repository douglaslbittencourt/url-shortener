# UrlShortener

[![Maintainability](https://api.codeclimate.com/v1/badges/45cfeb44822d09972ef7/maintainability)](https://codeclimate.com/github/douglaslbittencourt/UrlShortener-API)


Esta é uma API para serviço de encurtador de url.

O Encurtador de url é um serviço que converte url longas para url menores, assim facilitando para compartilhar url em mensagens, e-mails e afins. Quando o usuário abra a url encurtado será redirecionado a url original. 


# Como usar 

+ Api publica:

	- Abra https://douglas-url-shortener.herokuapp.com/swagger-ui.html para ver os endpoints. 

+ Com Docker e docker-compose: 

```sh
$ git clone https://github.com/douglaslbittencourt/url-shortener.git
$ cd url-shortener 
$ docker-compose up 
```

    - Abra localhost:8080/swagger-ui.html para ver os endpoints. 

+ Sem Docker: 

```sh
$ git clone https://github.com/douglaslbittencourt/url-shortener.git
```
    - Confira se tem acesso ao banco postgres.
    - Abra o projeto e altere o arquivo application.properties apontando os dada do do seu banco postgres
    - Build Spring
    - Abra localhost:8080/swagger-ui.html para ver os endpoints.

