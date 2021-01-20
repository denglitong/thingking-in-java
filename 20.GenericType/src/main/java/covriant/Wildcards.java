package covriant;

/**
 * @author denglitong
 * @date 2021/1/20
 */
public class Wildcards {
    static void rawArgs(Holder holder, Object arg) {
        // Unchecked call to 'set(T)' as a member of raw type 'covriant.Holder'
        holder.set(arg);

        // T t = holder.get();

        Object obj = holder.get();
    }

    static void unbounedArg(Holder<?> holder, Object arg) {
        // error: capture of ?, but provided Object
        // holder.set(arg);

        // T t = holder.get();

        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        return holder.get();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        return holder.get();
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // Required type: capture of ? extends T, Provided: T
        // holder.set(arg);

        return holder.get();
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
        // Required type: T, Provided: capture of ? extends T
        // T t = holder.get();
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<>();
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unbounedArg(raw, lng);
        unbounedArg(qualified, lng);
        unbounedArg(unbounded, lng);
        unbounedArg(bounded, lng);

        Object r1 = exact1(raw); // warning
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded); // must return Object
        Long r4 = exact1(bounded);

        Long r5 = exact2(raw, lng); // warning
        Long r6 = exact2(qualified, lng);
        // Long r7 = exact2(unbounded, lng);
        // Long r8 = exact2(bounded, lng);

        Long r9 = wildSubtype(raw, lng); // warning
        Long r10 = wildSubtype(qualified, lng);
        Object r11 = wildSubtype(unbounded, lng); // ok, but can only return Object
        Long r12 = wildSubtype(bounded, lng);

        wildSupertype(raw, lng); // warning
        wildSupertype(qualified, lng);
        // wildSupertype(unbounded, lng);
        // wildSupertype(bounded, lng);
    }
}
