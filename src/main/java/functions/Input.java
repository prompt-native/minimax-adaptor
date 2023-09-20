package functions;

import com.riguz.adaptor.prompt.Chat;

public class Input {
    private boolean debugMode;
    private String type;
    private Chat prompt;

    public Input() {
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Chat getPrompt() {
        return prompt;
    }

    public void setPrompt(Chat prompt) {
        this.prompt = prompt;
    }

    @Override
    public String toString() {
        return "Input{" +
                "debugMode=" + debugMode +
                ", type='" + type + '\'' +
                ", prompt=" + prompt +
                '}';
    }
}
