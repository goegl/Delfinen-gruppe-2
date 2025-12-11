public interface MillisecondConvertable {
    Long calculateResultInMilliseconds(int minutes, int seconds, int milliseconds);
    Disciplines getDisciplineFromInterface(MillisecondConvertable result);
    int getAgeOfMemberFromResult(MillisecondConvertable result);
    int calculateResultMinutes(String resultTime);
    int calculateResultSeconds(String resultTime);
    int calculateResultMillis(String resultTime);
    String getResultTimeFromResult(MillisecondConvertable result);
}
