package ua.lviv.touragency.model;

public class Tour {

    private String id;
    private TourType type;
    private String country;
    private int durationDays;
    private double price;
    private TransportType transport;
    private FoodType food;
    private String description;

    public Tour(String id,
                TourType type,
                String country,
                int durationDays,
                double price,
                TransportType transport,
                FoodType food,
                String description) {

        this.id = id;
        this.type = type;
        this.country = country;
        this.durationDays = durationDays;
        this.price = price;
        this.transport = transport;
        this.food = food;
        this.description = description;
    }

    public String getId() { return id; }
    public TourType getType() { return type; }
    public String getCountry() { return country; }
    public int getDurationDays() { return durationDays; }
    public double getPrice() { return price; }
    public TransportType getTransport() { return transport; }
    public FoodType getFood() { return food; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return String.format(
                "[%s] %s (%s) — %d днів, %.2f$, транспорт: %s, харчування: %s, %s",
                id, country, type, durationDays, price, transport, food, description
        );
    }
}
