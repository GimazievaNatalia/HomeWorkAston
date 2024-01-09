package lesson_4;

public class Park {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    // внутренний класс
    private class Attraction {
        private String attraction;
        private String time;
        private int price;

        public Attraction(String attraction, String time, int price) {
            this.attraction = attraction;
            this.time = time;
            this.price = price;
        }

    }
}

