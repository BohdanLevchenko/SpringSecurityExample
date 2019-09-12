# Public resources

```
$ curl -XGET http://localhost:8080/fast/api/public
public%
```

# Private resources

## Anonymous

```
$ curl -XGET http://localhost:8080/fast/api/private
```

```
HTTP/1.1 403 
Set-Cookie: JSESSIONID=B7869F95612A16D458DDD1D4A8B6F475; Path=/fast; HttpOnly
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Type: text/html;charset=utf-8
Content-Language: en
Content-Length: 1018
Date: Thu, 12 Sep 2019 06:06:43 GMT
```

## Authorization

```
$ curl -i -XPOST http://localhost:8080/fast/api/authenticate\?username\=admin\&password\=password
```

```
HTTP/1.1 302 
X-Granted-Authorities: ROLE_ADMIN
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Set-Cookie: JSESSIONID=6278BDD7AD1036449F85640898074697; Path=/fast; HttpOnly
Location: /fast/
Content-Length: 0
Date: Thu, 12 Sep 2019 06:01:48 GMT
```

## Authenticated

```
$ curl -i -XGET http://localhost:8080/fast/api/private -H 'Cookie: JSESSIONID=6278BDD7AD1036449F85640898074697'
```

```
HTTP/1.1 200 
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Type: text/plain;charset=ISO-8859-1
Content-Length: 15
Date: Thu, 12 Sep 2019 06:07:53 GMT

private (admin)%
```