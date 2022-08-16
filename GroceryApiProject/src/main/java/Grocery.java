import lombok.Data;

//Create object and assign values
@Data///having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor
public class Grocery {
    long id;
    String name;
    double price;
    int stock;
}