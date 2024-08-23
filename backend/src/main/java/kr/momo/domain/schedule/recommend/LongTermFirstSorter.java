package kr.momo.domain.schedule.recommend;

import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LongTermFirstSorter implements CandidateScheduleSorter {

    @Override
    public void sort(List<CandidateSchedule> unorderedSchedules) {
        Comparator<CandidateSchedule> comparator = Comparator.comparing(CandidateSchedule::groupSize, Comparator.reverseOrder())
                .thenComparing(CandidateSchedule::duration, Comparator.reverseOrder());
        unorderedSchedules.sort(comparator);
    }
}
