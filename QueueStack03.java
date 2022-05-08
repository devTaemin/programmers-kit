import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public Queue<Truck> Q = new LinkedList<Truck>();
    public Queue<Truck> Bridge = new LinkedList<Truck>();
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        for (int i = 0; i < truck_weights.length; i++) {
            Q.add(new Truck(truck_weights[i], 1));
        }
        
        int currentWeight = 0;
        int tick = 0;
        
        while(true) {
            // time past
            tick++;
            
            // Move truck
            int size = Bridge.size();
            for (int i = 0; i < size; i++) {
                Truck truck = Bridge.poll();
                truck.update();
                Bridge.add(truck); 
            }
            
            // Check Bridge
            if (!Bridge.isEmpty()) {
                Truck truck = Bridge.peek();
                if (truck.getL() > bridge_length) {
                    truck = Bridge.poll();
                    currentWeight -= truck.getW();
                }
            }
            
            // Check weight, bridge
            if (!Q.isEmpty()) {
                Truck truck = Q.peek();
                if (currentWeight + truck.getW() <= weight) {
                    truck = Q.poll();
                    Bridge.add(truck);
                    currentWeight += truck.getW();
                }
            }
            
            // Check queue and bridge
            if (Bridge.isEmpty() && Q.isEmpty()) break;
        }
        
        return tick;
    }
}

class Truck {
    private int w;
    private int location;
    
    public Truck (int w, int l) {
        this.w = w;
        this.location = l;
    }
    
    public int getW() {
        return this.w;
    }
    
    public int getL() {
        return this.location;
    }
    
    public void update() {
        this.location += 1;
    }
}