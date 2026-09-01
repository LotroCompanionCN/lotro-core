package delta.games.lotro.tools.tracker.engine;

import java.util.List;

import delta.games.lotro.tools.tracker.TrackedDataProvider;
import delta.games.lotro.tools.tracker.TrackedElement;

/**
 * Interface of a data tracker.
 * <p>
 * Such a tracker can:
 * <ul>
 * <li>give the list of managed element types,
 * <li>give a provider for a tracked element.
 * </ul>
 * @author DAM
 */
public interface Tracker
{
  /**
   * Get the managed tracked element types.
   * @return A list of type identifiers.
   */
  List<String> getTrackedElementTypes();
  /**
   * Get a provider for the given tracked element.
   * @param element Tracked element to use.
   * @return A data provider or <code>null</code> if not found.
   */
  TrackedDataProvider getDataProvider(TrackedElement element);
}
