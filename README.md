## 1차 요구사항 구현
- [x] 유저가 루트 url로 접속시에 게시글 리스트 페이지(http://주소:포트/article/list)가 나온다.
- [x] 리스트 페이지에서는 등록 버튼이 있고 버튼을 누르면 http://주소:포트/article/create 경로로 이동하고 등록 폼이 나온다.
- [x] 게시글 등록을 하면 http://주소:포트/article/create로 POST 요청을 보내어 DB에 해당 내용을 저장한다.
- [x] 게시글 등록이 되면 해당 게시글 리스트 페이지로 리다이렉트 된다. 페이지 URL 은 http://주소:포트/article/list 이다.
- [x] 리스트 페이지에서 해당 게시글을 클릭하면 상세페이지로 이동한다. 해당 경로는 http://주소:포트/article/detail/{id} 가 된다.
- [x] 게시글 상세 페이지에는 id에 맞는 게시글 데이터와 목록 버튼이 있다. 목록 버튼을 누르면 게시글 리스트 페이지로 이동하게 된다.

## MVC 패턴
- M(모델, 정보 데이터를 담음)
- V(뷰, 사용자 인터페이스)
- C(컨트롤러, 사용자 인터페이스와 데이터 사이의 다리)

* MVC 패턴은 디자인 패턴중에 하나이다.
* 유지보수에 용이한 패턴이다.

- 사용자의 Request을 Controller가 받는다. Controller는 Service에서 비즈니스 로직처리 후 Model에 담는다.
- 모델에 저장된 데이터를 바탕으로 View를 제어하여 사용자에게 전달한다.


## 스프링에서 의존성 주입(DI) 방법 3가지 방법
- 생성자 주입 - 클래스 생성자에 @Autowired 사용
- 단일 생성자면 생략 가능함.
~~~java
class SomeController {
	private final SomeRepository someRepository;
    
    @Autowired
    public SomeController(SomeRepository someRepository) {
    	this.someRepository = someRepository;
    }
}
~~~

- 필드 주입 - 필드에 @Autowired 사용
~~~java
class SomeController {
	@Autowired
    private final SomeRepository someRepository;
}
~~~

- 수정자 주입 - Setter 매서드에 @Autowired 사용
~~~java
class SomeController {
    private final SomeRepository someRepository;
    
    @Autowired
    public void setSomeRepository(SomeRepository someRepository) {
    	this.someRepository = someRepository;
    }
}
~~~

## JPA의 장점과 단점
### - 장점
- Hibernate는 SQL을 직접 사용하지 않고, 매서드 호출만으로 쿼리를 수행한다.
  그러므로 생산성이 올라간다는 장점이 있다.
- 특정 DB에 종속되지 않아 얼마든지 DB를 변경할 수 있다.

### - 단점
- 복잡한 쿼리를 사용할 경우에는 특정 DB에 종속된다.
- 자동으로 생성되는 쿼리가 많아 성능이 저하되기도 한다.
- 익히는데 필요한 학습시간이 많이 필요하다.



## HTTP GET 요청과 POST 요청의 차이
### - GET 요청
- 서버의 리소스에서 데이터를 요청할 때 사용한다. (SELECT 비슷)
- 요청을 전송할 때 데이터를 Body에 담지않고 쿼리스트링을 통해 전송한다.
- js,css 같은 정적 컨텐츠 데이터처럼 크기가 크다면 브라우저는 요청을 캐시해두고 불러올때마다 캐시된 데이터를 사용한다.

### - POST 요청
- 서버의 리소스를 생성 또는 업데이트할 때 사용 된다. (CREATE 비슷)
- 리소스를 생성, 변경하기위해 설계되었다.
- 요청을 전송할 때 Body에 담아서 전송한다. HTTP의 Body는 길이 제한이 없어서 대용량 데이터를 전송할 수 있다.