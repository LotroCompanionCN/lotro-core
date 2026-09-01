package delta.games.lotro.tools.tracker.deeds;

import delta.games.lotro.character.CharacterFile;
import delta.games.lotro.character.status.achievables.AchievableStatus;
import delta.games.lotro.character.status.achievables.AchievablesStatusManager;
import delta.games.lotro.lore.deeds.DeedDescription;
import delta.games.lotro.lore.deeds.DeedUtils;
import delta.games.lotro.tools.tracker.TrackedDataProvider;

/**
 * Base class for providers that use the status of deeds.
 * @author DAM
 */
public abstract class AbstractDeedTrackedDataProvider implements TrackedDataProvider
{
  private MultipleToonsDeedStatus _status;
  private DeedDescription _deed;

  /**
   * Constructor.
   * @param deed Deed to use.
   * @param status Status data.
   */
  public AbstractDeedTrackedDataProvider(DeedDescription deed, MultipleToonsDeedStatus status)
  {
    _status=status;
    _deed=deed;
  }

  @Override
  public String getIcon()
  {
    return DeedUtils.getDeedTypeIconPath(_deed.getType());
  }

  @Override
  public String getName()
  {
    return _deed.getName();
  }

  /**
   * Get the status of the managed deed for the given character.
   * @param toon Character to use.
   * @return A status or <code>null</code> if not found.
   */
  protected AchievableStatus getDeedStatus(CharacterFile toon)
  {
    String toonID=toon.getIdentifier();
    _status.getStatsForToon(toonID);
    AchievablesStatusManager statusMgr=_status.getStatsForToon(toonID);
    if (statusMgr==null)
    {
      _status.refreshToonData(toon);
      statusMgr=_status.getStatsForToon(toonID);
    }
    AchievableStatus ret=statusMgr.get(_deed,false);
    return ret;
  }
}
