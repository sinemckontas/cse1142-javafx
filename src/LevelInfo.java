public class LevelInfo {
    private String backgroundImagePath;
    private String levelText;
    private String[] optionTexts;
    private String correctOption;

    public LevelInfo(String backgroundImagePath, String levelText, String[] optionTexts, String correctOption) {
        this.backgroundImagePath = backgroundImagePath;
        this.levelText = levelText;
        this.optionTexts = optionTexts;
        this.correctOption = correctOption;
    }

    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }

    public void setBackgroundImagePath(String backgroundImagePath) {
        this.backgroundImagePath = backgroundImagePath;
    }

    public String getLevelText() {
        return levelText;
    }

    public void setLevelText(String levelText) {
        this.levelText = levelText;
    }

    public String[] getOptionTexts() {
        return optionTexts;
    }

    public void setOptionTexts(String[] optionTexts) {
        this.optionTexts = optionTexts;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }
}
