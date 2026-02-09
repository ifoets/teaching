package interview.preparation.company.interviews.design.american.express.record;

import java.util.UUID;

public record Transaction(UUID UUID, String date, String amount, String vendore, String category,String logStr) {
}
