package planningformen.domain.tyre;

/**
 *
 * @author bruger
 */
public class TyreSize
{
    private int _width;
    private int _profile;
    private int _diameter;
    
    public TyreSize(int width, int profile, int diameter)
    {
        _width = width;
        _profile = profile;
        _diameter = diameter;
    }

    public int getWidth() { return _width; }
    public int getProfile() { return _profile; }
    public int getDiameter() { return _diameter; }

    public void setWidth(int width) { _width = width; }
    public void setProfile(int profile) { _profile = profile; }
    public void setDiameter(int diameter) { _diameter = diameter; }
    
    @Override
    public boolean equals(Object object)
    {
        if(object instanceof TyreSize)
        {
            TyreSize size = (TyreSize)object;
            return size.getDiameter() == _diameter && size.getProfile() == _profile && size.getWidth() == _width;
        }
        return false;
    }
}