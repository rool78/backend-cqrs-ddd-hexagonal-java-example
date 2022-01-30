package publish;

import com.example.video.application.publish.VideoPublisher;
import com.example.video.domain.VideoPublished;
import com.example.video.infrastructure.HardcodedMemoryVideoRepository;
import org.junit.jupiter.api.Test;
import com.example.shared.domain.EventBus;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

final class VideoPublisherShould {
    @Test
    void publish_the_video_published_domain_event() {
        final EventBus eventBus = mock(EventBus.class);
        final VideoPublisher videoPublisher = new VideoPublisher(eventBus);

        final String videoTitle = "\uD83C\uDF89 New YouTube.com/ video title";
        final String videoDescription = "This should be the video description \uD83D\uDE42";

        videoPublisher.publish(videoTitle, videoDescription);

        final VideoPublished expectedVideoCreated = new VideoPublished(videoTitle, videoDescription);

        verify(eventBus).publish(List.of(expectedVideoCreated));
    }

}
