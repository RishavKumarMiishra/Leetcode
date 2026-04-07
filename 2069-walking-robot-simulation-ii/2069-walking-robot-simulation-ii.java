class Robot {
    int[] pos;
    int width;
    int height;
    int x;
    int y;
    String cur = "East";

    public Robot(int width, int height) {
        pos = new int[2];
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
    }
    
    public void step(int num) {
        int perimeter = ((2*height+2*width)-4);
        num = num%perimeter;
        if (num == 0) {
            num = perimeter;
        }
        while (num > 0) {
            if (cur.equals("East")) {
                x = x+num;
                if (x >= width) {
                    num = x-(width-1);
                    x = width-1;
                    cur = "North";
                } else {
                    num = 0;
                }
            } else if (cur.equals("North")) {
                y = y+num;
                if (y >= height) {
                    num = y-(height-1);
                    y = height-1;
                    cur = "West";
                } else {
                    num = 0;
                }
            } else if (cur.equals("West")) {
                x = x-num;
                if (x < 0) {
                    num = Math.abs(x);
                    x = 0;
                    cur = "South";
                } else {
                    num = 0;
                }
            } else {
                y = y -num;
                if (y < 0) {
                    num = Math.abs(y);
                    y = 0;
                    cur = "East";
                } else {
                    num = 0;
                }
            }
        }
    }
    
    public int[] getPos() {
        pos[0] = x;
        pos[1] = y;
        return pos;
    }
    
    public String getDir() {
        return cur;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */ 