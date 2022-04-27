# Exemples des controlleurs

## exemple génerique sans modification

```java
@RestController
@RequestMapping("/api/v1/units")
public class UnitController extends AbstractCrudController<Unit, UUID> {
}
```

## exemple génerique avec une méthode de plus
```java
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController extends AbstractCrudController<Order, UUID> {
	private OrderService service;

	@GetMapping("/by-customer-id")
	public List<Order> findByCustomer(UUID uuid) {
		return service.findByCustomer(uuid);
	}
}
```

## exemple d'une api de lecture seulement
```java
@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController extends AbstractReadController<Article, UUID> {
}
```
