package okio;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class PushableTimeout extends Timeout {
    private long originalDeadlineNanoTime;
    private boolean originalHasDeadline;
    private long originalTimeoutNanos;
    private Timeout pushed;

    PushableTimeout() {
    }

    void pop() {
        this.pushed.timeout(this.originalTimeoutNanos, TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline) {
            this.pushed.deadlineNanoTime(this.originalDeadlineNanoTime);
        } else {
            this.pushed.clearDeadline();
        }
    }

    void push(Timeout timeout) {
        long jDeadlineNanoTime;
        this.pushed = timeout;
        this.originalHasDeadline = timeout.hasDeadline();
        this.originalDeadlineNanoTime = this.originalHasDeadline ? timeout.deadlineNanoTime() : -1L;
        this.originalTimeoutNanos = timeout.timeoutNanos();
        timeout.timeout(minTimeout(this.originalTimeoutNanos, timeoutNanos()), TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline && hasDeadline()) {
            jDeadlineNanoTime = Math.min(deadlineNanoTime(), this.originalDeadlineNanoTime);
        } else if (!hasDeadline()) {
            return;
        } else {
            jDeadlineNanoTime = deadlineNanoTime();
        }
        timeout.deadlineNanoTime(jDeadlineNanoTime);
    }
}
