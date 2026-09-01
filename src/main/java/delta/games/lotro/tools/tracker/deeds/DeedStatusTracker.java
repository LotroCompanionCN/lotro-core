package delta.games.lotro.tools.tracker.deeds;

import java.util.ArrayList;
import java.util.List;

import delta.games.lotro.lore.deeds.DeedDescription;
import delta.games.lotro.lore.deeds.DeedsManager;
import delta.games.lotro.tools.tracker.ArgNames;
import delta.games.lotro.tools.tracker.TrackedDataProvider;
import delta.games.lotro.tools.tracker.TrackedElement;
import delta.games.lotro.tools.tracker.TrackedElementTypes;
import delta.games.lotro.tools.tracker.engine.Tracker;

/**
 * Tracker for the status of deeds.
 * @author DAM
 */
public class DeedStatusTracker implements Tracker
{
  private MultipleToonsDeedStatus _status;

  /**
   * Constructor.
   */
  public DeedStatusTracker()
  {
    _status=new MultipleToonsDeedStatus();
  }

  @Override
  public List<String> getTrackedElementTypes()
  {
    List<String> ret=new ArrayList<String>();
    ret.add(TrackedElementTypes.DEED_COMPLETED);
    return ret;
  }

  @Override
  public TrackedDataProvider getDataProvider(TrackedElement element)
  {
    String type=element.getType();
    if (TrackedElementTypes.DEED_COMPLETED.equals(type))
    {
      Integer id=(Integer)element.getArgValue(ArgNames.ID);
      DeedDescription deed=DeedsManager.getInstance().getDeed(id.intValue());
      return new DeedCompletedTrackedDataProvider(deed,_status);
    }
    return null;
  }
}
