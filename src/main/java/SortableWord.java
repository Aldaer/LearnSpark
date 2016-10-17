import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@EqualsAndHashCode
@RequiredArgsConstructor
public class SortableWord implements Comparable<SortableWord>, Serializable {
    private final String word;

    @Override
    public int compareTo(@NotNull SortableWord o) {
        int compareLength = word.length() - o.word.length();
        return (compareLength == 0) ? word.compareTo(o.word) : compareLength;
    }

    @Override
    public String toString() {
        return word;
    }
}
