package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCensor extends SocialChannelDecorator {

    private String censoredWord;

    public WordCensor(String censoredWord) {
        this.censoredWord = censoredWord;
    }

    public WordCensor(String censoredWord, SocialChannel channel) {
        this.censoredWord = censoredWord;
        this.delegate = channel;
    }

    @Override
    public void deliverMessage(String message) {
        Pattern p = Pattern.compile(censoredWord);
        Matcher m = p.matcher(message);
        StringBuffer sb = new StringBuffer();

        while (m.find()) {
            m.appendReplacement(sb, "###");
        }
        m.appendTail(sb);

        if (delegate != null)
            delegate.deliverMessage(sb.toString());

    }

}
