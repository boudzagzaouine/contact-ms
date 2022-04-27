# Exemples des repositories
il n'est pas obligatoire de définir le repository, il sera automatiquement généré sauf dans le cas où il y a un besoin pour ajouter une/des fonctionnalité(s)

## exemple d'ajout d'une fonctionnalité

```java
public interface OrderRepository extends BaseRepository<Order, UUID> {
	List<Order> findByCustomer(UUID cutomer);
}
```
