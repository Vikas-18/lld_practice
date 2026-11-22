package Parkinglot_Design;
public class HourlyPricing implements PricingStrategy {
    
    @Override
    public int calculatePrice(Ticket ticket) {
        // Hourly pricing logic
        String timeDuration = ticket.arrivalTime;
        String currentTime = java.time.LocalDateTime.now().toString();
        // Calculate the duration in hours (assuming timeDuration and currentTime are in a suitable format)
        long durationInMillis = java.time.Duration.between(java.time.LocalDateTime.parse(timeDuration), java.time.LocalDateTime.parse(currentTime)).toMillis();

        int timeDurationInHours = (int) (durationInMillis / (1000 * 60 * 60));
        if(timeDurationInHours == 0) {
            timeDurationInHours = 1; // Minimum charge for 1 hour
        }
        return timeDurationInHours * 10;
    }
}
