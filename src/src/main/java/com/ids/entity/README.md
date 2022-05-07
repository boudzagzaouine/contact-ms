# Exemples des entites

## Entité simple avec un id de type uuid

```java
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Unit extends EntityUuid {
	private static final long serialVersionUID = 1L;
	private String name;
}
```

## Entité simple avec un id de type Long

```java
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Category extends EntityLongId {
	private static final long serialVersionUID = 1L;
	private String name;
}
```

## Entités avec audit(createdDate, lastModifiedDate, createdBy, lastModifiedBy) avec un id de type UUID
Notez l'utilisation de @ToString.Exclude pour ne pas avoir des problemes de perf ou de session

```java
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Article extends AuditableEntityId<UUID> {
	private static final long serialVersionUID = 1L;
	
	private String name;
	// pour les nombres réels, il faut utiliser BigDecimal
	private BigDecimal price;
	@ToString.Exclude
	@ManyToOne
	private Category category;
	@ToString.Exclude
	@ManyToOne
	private Unit unit;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> configuration;
}

@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Customer extends AuditableEntityId<UUID> {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String mail;
    private String phone;
    // pour les dates, il faut utiliser LocalDate
    private LocalDate birthDate;
    
    @Singular
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> others;
}
```

## Exemple OneToMany 

```java
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class OrderLine extends EntityUuid {
	private static final long serialVersionUID = 1L;
	private UUID article;
	private String name;
	private BigDecimal quantity;
	private BigDecimal price;
	private BigDecimal discount;
}

@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "orders")
public class Order extends AuditableEntityId<UUID> {

	private static final long serialVersionUID = 1L;

	private UUID customer;
	private String name;
	// pour les timestamp, il faut utiliser LocalDateTime
	private LocalDateTime date;
	@ToString.Exclude
	@Singular
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id")
	private Set<OrderLine> lines;
}
```