public interface Set<E extends Comparable<E>> {

    /**
     * @param e an element to search for
     * @return true if an element that compares equal to e is present, false otherwise.
     */
    boolean contains(E e);

    /**
     * Insert e into the container. What should be done if e is null? What should be done if an
     * element equal to e is present?
     *
     * post: size(pre) + 1 == size(post). contains(e) == true
     *
     * @param e an element to add to the container.
     *
     *
     */
    void add(E e);

    /**
     * if an element that compares equal to e is present, remove it. What should be done if e
     * appears multiple times?
     *
     * post: size(post) == size(pre) || size(post) == size(pre) - 1. The number
     *       of elements that compare equal to e == 0 or it has been reduced by 1.
     *
     * @param e an element to remove, if present.
     */
    void remove(E e);

    /**
     *
     * @return the number of elements in the container
     */
    int size();

    /**
     * return true if there are no elements, false otherwise.
     */
    boolean isEmpty();
}
