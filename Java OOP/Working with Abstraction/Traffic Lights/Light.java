public class Light {
    private Colors color;

    public Light(Colors color) {
        this.color = color;
    }

    public void changeColors() {
        if(this.color.equals(Colors.RED)) {
            this.color = Colors.GREEN;
        }else if(this.color.equals(Colors.GREEN)) {
            this.color = Colors.YELLOW;
        }else if(this.color.equals(Colors.YELLOW)) {
            this.color = Colors.RED;
        }
    }

    public Colors getColor() {
        return color;
    }
}
