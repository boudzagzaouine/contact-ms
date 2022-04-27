# Exemples des services
il n'est pas obligatoire de définir le service, il sera automatiquement généré sauf dans le cas où il faut modifier ou ajouter une fonctionnalité

## exemple d'un service avec l'ajout d'une nouvelle fonctionnalité 

```java
@TransactionalService
public class OrderService extends AbstractService<Order, UUID> {
	@Autowired
	private OrderRepository repository;
	public List<Order> findByCustomer(UUID customer) {
		return repository.findByCustomer(customer);
	}
}
```

## exemple d'un service avec la modification d'une fonctionnalité 

```java
@TransactionalService
public class ArticleService extends AbstractService<Article, UUID> {
	@Override
	public Article create(Article entity) {
		System.out.println("appel save custom ");
		return super.create(entity);
	}
}
```
