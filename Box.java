public class Box {
    private int max, mid, min;

    public Box(int sizeX, int sizeY, int sizeZ) {
        this.max = Math.max(sizeX, Math.max(sizeY, sizeZ));
        this.min = Math.min(sizeX, Math.min(sizeY, sizeZ));
        this.mid = sizeX + sizeY + sizeZ - this.max - this.min;
    }

    public boolean fitsIn(Box box) {
        return this.max < box.getMax() || this.mid < box.getMid() || this.min < box.getMin();
    }

    public int getMax() {
        return max;
    }

    public int getMid() {
        return mid;
    }

    public int getMin() {
        return min;
    }

    public String toString(){
        return max + "-" + mid + "-" + min;
    }
}
