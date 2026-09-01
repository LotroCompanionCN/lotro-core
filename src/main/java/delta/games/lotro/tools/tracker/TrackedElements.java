package delta.games.lotro.tools.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection of tracked elements.
 * @author DAM
 */
public class TrackedElements
{
  private List<TrackedElement> _elements;

  /**
   * Constructor.
   */
  public TrackedElements()
  {
    _elements=new ArrayList<TrackedElement>();
  }

  /**
   * Add an element.
   * @param element Element to add.
   */
  public void addElement(TrackedElement element)
  {
    _elements.add(element);
  }

  /**
   * Get the elements in this collection.
   * @return A list of tracked elements.
   */
  public List<TrackedElement> getElements()
  {
    return _elements;
  }
}
